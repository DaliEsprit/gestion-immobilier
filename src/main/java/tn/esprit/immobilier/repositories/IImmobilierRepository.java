package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Immobilier;

public interface IImmobilierRepository extends JpaRepository<Immobilier, Integer> {
}
