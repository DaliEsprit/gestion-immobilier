package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Feedback;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long> {
}
