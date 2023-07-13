package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {


    Reservation ajouterReservation(Reservation r,long idimmo, long iduser);

    void deleteReservation(Long idreservation);



    public  Reservation updateReservationDate (Long idres , Date date);



}
