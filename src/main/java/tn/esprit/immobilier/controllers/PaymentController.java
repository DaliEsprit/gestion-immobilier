package tn.esprit.immobilier.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Payement;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.entities.enums.PaymentStatus;
import tn.esprit.immobilier.services.IPayementService;

import java.util.List;

@RestController
@RequestMapping("/payement")
@AllArgsConstructor
@CrossOrigin("*")
public class PaymentController {

    IPayementService iPayementService;
    @PostMapping("/add-payement/{PaymentStatus}")
    @ResponseBody
    public Payement ajouterPayement(@RequestBody  Payement p , @PathVariable("PaymentStatus")PaymentStatus paymentStatus){
        return this.iPayementService.ajouterPayement(p,paymentStatus);
    }
    @PutMapping("/update-payement/{id}")
    public Payement updatePayement(@RequestBody Payement payement){
        return this.iPayementService.updatePayement(payement);
    }
    @GetMapping("/retrieve-all-payement")
    public List<Payement> retrieveAllPayement(){
        return this.iPayementService.retrieveAllPayement();
    }
    @DeleteMapping("/delete-payement/{idPayement}")
    public void deletePayment(@PathVariable("idPayement") long id){
         this.iPayementService.deletePayement(id);
    }
    @GetMapping("retrieve-pay-by-id/{payid}")
    Payement getPayementById(@PathVariable("payid") long pid){
        return  this.iPayementService.getPaymentById(pid);
    }
}
