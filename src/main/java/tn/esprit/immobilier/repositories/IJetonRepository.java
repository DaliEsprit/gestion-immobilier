package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.immobilier.entities.Jeton;

import java.util.List;

public interface IJetonRepository extends JpaRepository<Jeton,Long> {
    Jeton getJetonByUser_Id(long userid);
    List<Jeton> getJetonsByRoom_Id(long roomId);
}
