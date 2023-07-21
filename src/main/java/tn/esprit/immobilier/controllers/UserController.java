package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.security.jwt.JwtResponse;
import tn.esprit.immobilier.services.IUserService;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity getCurrentInfo( HttpServletRequest req){
        return ResponseEntity.ok(userService.getCurrentInfo()) ;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PutMapping
    public ResponseEntity<User> getAllUsers(@RequestBody User user){
        return ResponseEntity.ok(userService.update(user));
    }
    @GetMapping("/disable/{id}")
    public ResponseEntity disable(@PathVariable("id") long id){
        userService.disable(id);
       return  ResponseEntity.accepted().build();
    }
}
