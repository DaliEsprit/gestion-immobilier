package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Attachement;

public interface IAttachmentRepository extends JpaRepository<Attachement, Integer> {
}
