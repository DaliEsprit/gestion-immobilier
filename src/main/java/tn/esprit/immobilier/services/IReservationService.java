package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();

    Reservation ajouterReservation(Reservation c);

    void deleteReservation(Long id);

    Reservation updateReservation(Reservation c);
}
