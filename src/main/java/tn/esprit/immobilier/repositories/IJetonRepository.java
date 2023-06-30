package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Jeton;

public interface IJetonRepository extends JpaRepository<Jeton,Long> {
    Jeton getJetonByUser_Id(long userId);
}
