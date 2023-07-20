package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Feedback;
import tn.esprit.immobilier.entities.Room;

import java.util.List;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long> {

   
}
