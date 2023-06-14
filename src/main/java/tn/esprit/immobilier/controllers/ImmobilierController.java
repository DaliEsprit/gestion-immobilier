package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.services.IImmobilierService;

import java.util.List;

@RestController
@RequestMapping("immobilier")
public class ImmobilierController {
    @Autowired
    IImmobilierService immobilierService;

    @GetMapping
    public List<Immobilier> findAll(){
        return immobilierService.retrieveAllImmobilier();
    }
}
