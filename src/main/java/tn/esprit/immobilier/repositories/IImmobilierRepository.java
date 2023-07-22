package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.entities.Jeton;

import java.util.List;

public interface IImmobilierRepository  extends JpaRepository<Immobilier,Long> {

    Immobilier getImmobilierByRoom_Id(long idRoom);
    Immobilier getImmobilierByName(String name);

}
