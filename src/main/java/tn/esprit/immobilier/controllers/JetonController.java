package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Jeton;
import tn.esprit.immobilier.services.IJetonService;

import java.util.List;

@RestController
public class JetonController {
    IJetonService jetonService;

    @PostMapping("/add-jeton")
    public Jeton addJeton(@RequestBody Jeton jeton) {
        return
                jetonService.ajouterJeton(jeton);
    }



    // http://localhost:8089/api/immobilier/retrieve-all-immobilier
    @GetMapping("/retrieve-all-jeton")
    public List<Jeton> getJeton() {
        List<Jeton> listJeton = jetonService.retrieveAllJeton();
        return listJeton;
    }

    @DeleteMapping("/remove-jeton/{jeton-id}")
    public void removeJeton(@PathVariable("jeton-id") Long jetonid) {
        jetonService.deleteJeton(jetonid);
    }
    @PutMapping("/modify-jeton")
    public Jeton updateJeton(@RequestBody Jeton jeton) {
        return jetonService.updateJeton(jeton);
    }
}
