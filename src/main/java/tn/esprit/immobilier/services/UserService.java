package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Token;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.repositories.IUserRepository;
import tn.esprit.immobilier.security.services.UserDetailsImpl;
import tn.esprit.immobilier.utils.MailService;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IAuthService authService;
    @Autowired
    ITokenService tokenService;
    @Autowired
    MailService mailService;
    @Override
    public User createUser(User user){
        User exist = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (exist!=null) throw new RuntimeException("user already exist");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userSaved = userRepository.save(user);
        Token token = tokenService.generateAndSave(userSaved);
        String link = "http://localhost:4200/verify-mail/"+token.getToken();
        mailService.sendMail(user.getEmail(), "verify mail",link);
        return userSaved;
    }

    @Override
    public List<User> retrieveAllReservation() {
        List<User> listReservation= userRepository.findAll();
        return listReservation;
    }



    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User update(User c) {
        userRepository.save(c);
        return c;
    }

    @Override
    public User getCurrentInfo(){
        UserDetailsImpl userDetails = authService.getCurrent();
        return userRepository.findByEmail(userDetails.getEmail()).orElse(null);
    }
}
