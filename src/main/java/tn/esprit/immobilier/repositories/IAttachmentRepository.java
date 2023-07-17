package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Attachement;

import java.util.List;

public interface IAttachmentRepository extends JpaRepository<Attachement, Long> {

    List<Attachement> findAttachementsByImmobilier_Id(Long id);
}
