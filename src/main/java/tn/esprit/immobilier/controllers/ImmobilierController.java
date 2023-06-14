package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.services.ImmoblierService;

import java.util.List;
@RestController

@RequestMapping("/immobilier")
public class ImmobilierController {
    @Autowired
    ImmoblierService immobilierService;
    // http://localhost:8089/api/immobilier/retrieve-all-immobilier
    @GetMapping("/retrieve-all-immobilier")
    public List<Immobilier> getImmobilier() {
        List<Immobilier> listImmobiliers = immobilierService.retrieveAllImmobilier();
        return listImmobiliers;
    }
    @PostMapping("/add-immobilier")
    public Immobilier addImmobilier(@RequestBody Immobilier c) {
        return
                immobilierService.ajouterImmobilier(c);
    }
    @DeleteMapping("/remove-immobilier/{immobilier-id}")
    public void removeReservation(@PathVariable("immobilier-id") Long immobilierId) {
        immobilierService.deleteImmobilier(immobilierId);
    }
    @PutMapping("/modify-immobilier")
    public Immobilier updateReservation(@RequestBody Immobilier immobilier) {
        return immobilierService.updateImmobilier(immobilier);
    }
}
