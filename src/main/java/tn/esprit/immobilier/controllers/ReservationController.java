package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Reservation;
import tn.esprit.immobilier.services.IReservationService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    IReservationService reservationService;
    // http://localhost:8089/api/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservation() {
        List<Reservation> listReservations = reservationService.retrieveAllReservation();
        return listReservations;
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation c) {
        return reservationService.ajouterReservation(c);
    }
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }
    @PutMapping("/modify-reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }
}
