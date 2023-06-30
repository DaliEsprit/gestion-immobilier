package tn.esprit.immobilier.services;

import tn.esprit.immobilier.dto.LoginDTO;
import tn.esprit.immobilier.security.jwt.JwtResponse;
import tn.esprit.immobilier.security.services.UserDetailsImpl;

public interface IAuthService {
    JwtResponse signIn(LoginDTO loginDTO);

    UserDetailsImpl getCurrent();
}
