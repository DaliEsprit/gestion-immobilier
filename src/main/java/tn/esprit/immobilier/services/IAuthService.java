package tn.esprit.immobilier.services;

import tn.esprit.immobilier.dto.LoginDTO;
import tn.esprit.immobilier.security.jwt.JwtResponse;

public interface IAuthService {
    JwtResponse signIn(LoginDTO loginDTO);
}
