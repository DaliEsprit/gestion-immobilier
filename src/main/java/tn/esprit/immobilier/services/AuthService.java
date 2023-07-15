package tn.esprit.immobilier.services;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.dto.LoginDTO;
import tn.esprit.immobilier.dto.SocialLoginDto;
import tn.esprit.immobilier.dto.UpdatePwdDTO;
import tn.esprit.immobilier.entities.Token;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.entities.enums.RolesTypes;
import tn.esprit.immobilier.repositories.ITokenRepository;
import tn.esprit.immobilier.repositories.IUserRepository;
import tn.esprit.immobilier.security.jwt.JwtResponse;
import tn.esprit.immobilier.security.jwt.JwtUtils;
import tn.esprit.immobilier.security.services.UserDetailsImpl;
import tn.esprit.immobilier.utils.MailService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

     IUserRepository userRepository;

    AuthenticationManager authenticationManager;

    JwtUtils jwtUtils;
    PasswordEncoder passwordEncoder;
    ITokenRepository tokenRepository;
    MailService mailService;
    TokenService tokenService;
    @Override
    public JwtResponse signIn(LoginDTO loginDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);
    }

    @Override
    public UserDetailsImpl getCurrent(){
        System.out.println( SecurityContextHolder.getContext().getAuthentication().getPrincipal());
       return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public JwtResponse verifyToken(String token) {
        Token validToken = tokenRepository.findByTokenAndEnabled(token,true).orElseThrow(()->new RuntimeException("Invalid or expired token"));
        User user = validToken.getUser();
        user.setMailVerified(true);
        userRepository.save(user);
        validToken.setEnabled(false);
        tokenRepository.save(validToken);
        return loginUser(user);

    }

    @Override
    public void verifyPasswordToken(String token) {
         tokenRepository.findByTokenAndEnabled(token,true).orElseThrow(()->new RuntimeException("Invalid or expired token"));
    }

    @Override
    public void updatePassword(String token,String password) {
       Token token1= tokenRepository.findByTokenAndEnabled(token,true).orElseThrow(()->new RuntimeException("Invalid or expired token"));
        User user = token1.getUser();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
    JwtResponse loginUser(User user){
    Authentication authentication = new UsernamePasswordAuthenticationToken(new UserDetailsImpl(user.getId(), user.getEmail(),user.getEmail(),null,user.isEnabled()
            , Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()))), null, null);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());


    return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
}
    @Override
   public void sendUpdatePasswordEmail(String email){
      Optional<User> user = userRepository.findByEmail(email);
      if(user.isPresent()){
          Token token = tokenService.generateAndSave(user.get());
          String link = "http://localhost:4200/update-password/"+token.getToken();
          mailService.sendMail(email,"update password",link);
      }
    }

    @Override
    public void updatePwd(UpdatePwdDTO updatePwdDTO){
        Token validToken = tokenRepository.findByTokenAndEnabled(updatePwdDTO.getToken(),true).orElseThrow(()->new RuntimeException("Invalid or expired token"));
        userRepository.save(validToken.getUser());
        User user= validToken.getUser();
        passwordEncoder.matches(updatePwdDTO.getOldPwd(),user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        validToken.setEnabled(false);
    }

    @Override
    public JwtResponse socialLogin(SocialLoginDto socialLoginDto){
        User user = userRepository.findBySocialId(socialLoginDto.getId()).orElse(new User());
        if(user.getEmail()!=null){
            return loginUser(user);
        }
        user.setEmail(socialLoginDto.getEmail());
        user.setEnabled(true);
        user.setFirstName(socialLoginDto.getFirstName());
        user.setFirstName(socialLoginDto.getLastName());
        user.setEnabled(true);
        user.setSocialId(socialLoginDto.getId());
        user.setRole(RolesTypes.ROLE_GUEST);

        return loginUser(userRepository.save(user));
    }
}
