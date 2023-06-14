package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Position;
import tn.esprit.immobilier.services.IAttachmentService;
import tn.esprit.immobilier.services.IPositionService;

import java.util.List;

@RestController

@RequestMapping("/attachement")
public class AttachmentController {
    @Autowired
    IAttachmentService attachementService;
    // http://localhost:8089/api/immobilier/retrieve-all-immobilier
    @GetMapping("/retrieve-all-attachement")
    public List<Attachement> getAttachement() {
        List<Attachement> listAttachement = attachementService.retrieveAllAttachement();
        return listAttachement;
    }
    @PostMapping("/add-attachement")
    public Attachement addAttachement(@RequestBody Attachement c) {
        return
                attachementService.ajouterAttachement(c);
    }
    @DeleteMapping("/remove-position/{attachement-id}")
    public void removeAttachement(@PathVariable("attachement-id") Long attachementId) {
        attachementService.deleteAttachement(attachementId);
    }
    @PutMapping("/modify-attachement")
    public Attachement updateAttachement(@RequestBody Attachement attachement) {
        return attachementService.updateAttachement(attachement);
    }
}
