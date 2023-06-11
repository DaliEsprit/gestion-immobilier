package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.entities.Jeton;

public interface IImmobilierRepository  extends JpaRepository<Immobilier,Long> {
}
