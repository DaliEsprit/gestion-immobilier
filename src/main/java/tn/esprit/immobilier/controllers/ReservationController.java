package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.immobilier.NotifierAlgo.NotifService;
import tn.esprit.immobilier.entities.Reservation;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.services.IReservationService;
import tn.esprit.immobilier.services.IUserService;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    IReservationService reservationService;
    
    @Autowired
    IUserService userService;
    
    @Autowired
	private NotifService notifService;
    
   

    @PostMapping("/add-reservation/{idimmo}/{iduser}")
    public Reservation addReservation(@RequestBody Reservation r,@PathVariable("idimmo") long idimmo, @PathVariable("iduser") long iduser) {
    	

		
        return reservationService.ajouterReservation(r,idimmo,iduser);
    }
    @DeleteMapping("/remove-reservation/{idreservation}")
    public void removeReservation(@PathVariable("idreservation") Long idreservation) {
        reservationService.deleteReservation(idreservation);
    }
    @PutMapping("/modify-reservation/{idres}/{date}")
    public Reservation updateReservation(@PathVariable("idres") long idres, @PathVariable("date")String date) {
        return reservationService.updateReservationDate(idres,date);
    }
}
