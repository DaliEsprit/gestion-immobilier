package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/current")
    public User getCurrentInfo(){
        return userService. getCurrentInfo();
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.retrieveAllReservation();
    }

}
