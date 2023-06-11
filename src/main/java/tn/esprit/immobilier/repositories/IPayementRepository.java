package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Payement;

public interface IPayementRepository extends JpaRepository<Payement, Long> {
}
