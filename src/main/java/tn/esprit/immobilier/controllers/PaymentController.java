package tn.esprit.immobilier.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Payement;
import tn.esprit.immobilier.services.IPayementService;

import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class PaymentController {
    IPayementService iPayementService;
    @PostMapping("/add-payment")
    public Payement ajouterPayement(Payement p){
        return this.iPayementService.ajouterPayement(p);
    }
    @GetMapping("/retrieve-all-payment")
    public List<Payement> retrieveAllPayement(){
        return this.iPayementService.retrieveAllPayement();
    }
    @DeleteMapping("/delete-payment/{idPayment}")
    public void deletePayment(@PathVariable("idPayment") long id){
         this.iPayementService.deletePayement(id);
    }
    @PutMapping("/update-payment")
    public Payement updatePayement(Payement payement){
        return this.iPayementService.updatePayement(payement);
    }
}
