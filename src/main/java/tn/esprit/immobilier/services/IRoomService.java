package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Reservation;
import tn.esprit.immobilier.entities.Room;

import java.util.List;

public interface IRoomService {
    List<Room> retrieveAllRoom();

    Room ajouterRoom(Room r);

    void deleteRoom(Long id);

    Room updateRoom(Room r);


}
