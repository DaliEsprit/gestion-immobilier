package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Room;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Room,Long> {
    List<Room> getRoomsByUser_Id(long userId);
    Room getRoomById(long idRoom);
}
