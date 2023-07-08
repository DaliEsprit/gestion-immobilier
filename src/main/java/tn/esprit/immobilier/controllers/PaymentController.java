package tn.esprit.immobilier.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Payement;
import tn.esprit.immobilier.services.IPayementService;

import java.util.List;

@RestController
@RequestMapping("/payement")
@AllArgsConstructor
@CrossOrigin("*")
public class PaymentController {

    IPayementService iPayementService;
    @PostMapping("/add-payement")
    @ResponseBody
    public Payement ajouterPayement(@RequestBody  Payement p){
        return this.iPayementService.ajouterPayement(p);
    }
    @GetMapping("/retrieve-all-payement")
    public List<Payement> retrieveAllPayement(){
        return this.iPayementService.retrieveAllPayement();
    }
    @DeleteMapping("/delete-payement/{idPayement}")
    public void deletePayment(@PathVariable("idPayement") long id){
         this.iPayementService.deletePayement(id);
    }
    @PutMapping("/update-payement")
    public Payement updatePayement(Payement payement){
        return this.iPayementService.updatePayement(payement);
    }
}
