package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Reservation;
import tn.esprit.immobilier.repositories.IAttachmentRepository;
import tn.esprit.immobilier.repositories.IReservationRepository;

import java.util.List;
@Service

public class ReservationService implements IReservationService {
    @Autowired
    IReservationRepository ReservRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {
        List<Reservation> listReservation= ReservRepository.findAll();
        return listReservation;
    }

    @Override
    public Reservation ajouterReservation(Reservation c) {
        ReservRepository.save(c);
        return c;
    }

    @Override
    public void deleteReservation(Long id) {
        ReservRepository.deleteById(id);

    }

    @Override
    public Reservation updateReservation(Reservation c) {
        ReservRepository.save(c);
        return c;
    }
}
