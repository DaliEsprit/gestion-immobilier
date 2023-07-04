package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Reservation;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.entities.User;

import java.util.List;

public interface IRoomService {
    List<Room> retrieveAllRoom();

    Room ajouterRoom(Room r);

    void deleteRoom(Long id);

    Room updateRoom(Room r);
    List<User> getUsersByRoom(long idRoom);
    String assignUserToRoom(long idUser,long idRoom);


}
