package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.dto.LoginDTO;
import tn.esprit.immobilier.dto.SocialLoginDto;
import tn.esprit.immobilier.dto.UpdatePwdDTO;
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

    @GetMapping("/verify-email/{token}")
    public JwtResponse verifyToken(@PathVariable("token") String token){
        return authService.verifyToken(token);
    }

    @GetMapping("/send-update-pwd/{email}")
    public ResponseEntity<Void> sendUpdatePwdMail(@PathVariable("email") String email){
        authService.sendUpdatePasswordEmail(email);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/update-password")
    public ResponseEntity<Void> updatePwd(@RequestParam("token") String token,@RequestParam("password") String password){
        authService.updatePassword(token,password);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/verify-password-token/{token}")
    public ResponseEntity<Void> verifyPasswordToken(@PathVariable("token") String token){
         authService.verifyPasswordToken(token);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/social-login")
    public ResponseEntity<JwtResponse> socialLogin(@RequestBody SocialLoginDto loginDTO){
        return ResponseEntity.ok(authService.socialLogin(loginDTO));

    }
}
