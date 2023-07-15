package tn.esprit.immobilier.services;

import tn.esprit.immobilier.dto.LoginDTO;
import tn.esprit.immobilier.dto.SocialLoginDto;
import tn.esprit.immobilier.dto.UpdatePwdDTO;
import tn.esprit.immobilier.security.jwt.JwtResponse;
import tn.esprit.immobilier.security.services.UserDetailsImpl;

public interface IAuthService {
    JwtResponse signIn(LoginDTO loginDTO);

    UserDetailsImpl getCurrent();

    JwtResponse verifyToken(String token);

    void verifyPasswordToken(String token);

    void updatePassword(String token, String password);

    void sendUpdatePasswordEmail(String email);

    void updatePwd(UpdatePwdDTO updatePwdDTO);

    JwtResponse socialLogin(SocialLoginDto socialLoginDto,String longitude,String latitude);
}
