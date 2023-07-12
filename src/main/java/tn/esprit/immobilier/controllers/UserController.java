package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.security.jwt.JwtResponse;
import tn.esprit.immobilier.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseEntity<JwtResponse> create(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }
    @GetMapping("/current")
    public ResponseEntity getCurrentInfo(){
        try {
            userService. getCurrentInfo();

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build() ;

        }
        return ResponseEntity.accepted().build() ;
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.retrieveAllReservation();
    }

}
