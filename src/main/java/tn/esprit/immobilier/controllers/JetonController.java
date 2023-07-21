package tn.esprit.immobilier.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Jeton;
import tn.esprit.immobilier.entities.enums.JetonStatus;
import tn.esprit.immobilier.services.IJetonService;
import tn.esprit.immobilier.services.JetonService;

import java.util.List;

@RestController
@RequestMapping("/jeton")
@CrossOrigin("*")
@AllArgsConstructor
public class JetonController {
 @Autowired
     JetonService jetonService;

    @PostMapping("/add-jeton")
    public Jeton addJeton(@RequestBody Jeton jeton) {
        return jetonService.ajouterJeton(jeton);
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
    @PutMapping("/modify-jeton/{idUser}/{idRoom}")
    public Jeton updateJeton(@RequestBody Jeton jeton,@PathVariable("idUser") long iduser,@PathVariable("idRoom") long idRoom) {
        return jetonService.updateJeton(jeton,iduser,idRoom);
    }

    @GetMapping("/getJetonByUser/{userId}")
    public Jeton getJetonByUser(@PathVariable("userId") long userId){
        return jetonService.getJetonByUser(userId);
    }
    @GetMapping("/getJetonByRoom/{roomId}")
    public List<Jeton> getJetonsbyRoom(@PathVariable("roomId") long roomId){
        return  jetonService.getJetonbyRoom(roomId);
    }
    @PutMapping("/update-jeton-bid-value/{jetonId}/{amount}")
    public Jeton updateJetonBidValue (@PathVariable("jetonId") long jetonid,@PathVariable("amount")double amount){
        return  jetonService.updateUserBidAmount(jetonid,amount);
    }
    @PutMapping("/updateJetonStatus/{userId}/{jetonStatus}")
    public Jeton updateJetonStatus (@PathVariable("userId") long userid, @PathVariable("jetonStatus")JetonStatus jetonStatus){
        return jetonService.updateJetonStatus(userid, jetonStatus);
    }
}
