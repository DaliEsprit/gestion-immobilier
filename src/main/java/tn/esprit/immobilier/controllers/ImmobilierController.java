package tn.esprit.immobilier.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import tn.esprit.immobilier.NotifierAlgo.NotifService;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.services.IUserService;
import tn.esprit.immobilier.services.ImmoblierService;

import java.util.List;
@RestController

@RequestMapping("/immobilier")
@CrossOrigin("*")
public class ImmobilierController {
	
    @Autowired
    ImmoblierService immobilierService;
    
    @Autowired
    IUserService userService;
    
    @Autowired
	private NotifService notifService;
    
    // http://localhost:8089/api/immobilier/retrieve-all-immobilier
    @GetMapping("/retrieve-all-immobilier")
    public List<Immobilier> getImmobilier() {
        List<Immobilier> listImmobiliers = immobilierService.retrieveAllImmobilier();
        return listImmobiliers;
    }
    @PostMapping("/add-immobilier")
    public Immobilier addImmobilier(@RequestBody Immobilier c) {
    	
    	User x = userService.getCurrentInfo();
    	
    	int input_case =0; // lechkoun n7eb npushi notification
		String title = "Creation nouveau Immobilier";
		String message = "l' Utilisateur : Mr/Mme. " + " " +x.getFirstName() + " " + x.getLastName() + " " + "qui est : " + " " + x.getRole() 
		 + " " +"a crée un nouveau immobilier pour : " + " " + c.getStatus();
		
		notifService.notifier(input_case, title, message);
    	
        return
                immobilierService.ajouterImmobilier(c);
    }
    
    
    
    
    @DeleteMapping("/remove-immobilier/{immobilier-id}")
    public void removeImmobilier(@PathVariable("immobilier-id") Long immobilierId) {
    	
   
    	
        immobilierService.deleteImmobilier(immobilierId);
    }
    
    
    @PutMapping("/modify-immobilier")
    public Immobilier updateImmobilier(@RequestBody Immobilier immobilier) {
        return immobilierService.updateImmobilier(immobilier);
    }
}
