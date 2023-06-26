package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.dto.LoginDTO;
import tn.esprit.immobilier.security.jwt.JwtResponse;
import tn.esprit.immobilier.services.IAuthService;

@RestController
@RequestMapping("auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    IAuthService authService;

    @PostMapping("/signIn")
    public ResponseEntity<JwtResponse> signIn(@RequestBody LoginDTO loginDTO){
            return ResponseEntity.ok(authService.signIn(loginDTO));

    }
}
