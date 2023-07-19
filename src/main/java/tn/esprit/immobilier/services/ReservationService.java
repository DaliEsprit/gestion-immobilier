package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.entities.Reservation;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.repositories.IAttachmentRepository;
import tn.esprit.immobilier.repositories.IImmobilierRepository;
import tn.esprit.immobilier.repositories.IReservationRepository;
import tn.esprit.immobilier.repositories.IUserRepository;

import java.util.Date;
import java.util.List;
@Service

public class ReservationService implements IReservationService {
    @Autowired
    IReservationRepository ReservRepository;
    @Autowired
    IImmobilierRepository immobilierRepository;
    @Autowired
    IUserRepository userRepository;


    @Override
    public Reservation ajouterReservation(Reservation r,long idimmo, long iduser) {

        Immobilier immobilier=immobilierRepository.findById(idimmo).get();
        User user = userRepository.findById(iduser).get();
        r.setImmobilier(immobilier);
        r.setUser(user);

        return ReservRepository.save(r);

    }



    @Override
    public void deleteReservation(Long idreservation) {
        ReservRepository.deleteById(idreservation);

    }



    @Override
    public Reservation updateReservationDate(Long idres, String date) {

        Reservation reservation = ReservRepository.findById(idres).get();


        return ReservRepository.save(reservation);
    }
}
