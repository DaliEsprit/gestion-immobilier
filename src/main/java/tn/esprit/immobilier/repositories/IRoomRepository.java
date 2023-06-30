package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Room;

public interface IRoomRepository extends JpaRepository<Room,Long> {
}
