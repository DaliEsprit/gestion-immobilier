package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
