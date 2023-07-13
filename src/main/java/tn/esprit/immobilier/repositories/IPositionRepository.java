package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Position;

public interface IPositionRepository extends JpaRepository<Position, Long> {
    void deletePositionByIdPosition(Integer id);
}
