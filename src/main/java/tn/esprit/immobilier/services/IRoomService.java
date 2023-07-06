package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.*;

import java.util.List;

public interface IRoomService {
    List<Room> retrieveAllRoom();

    Room ajouterRoom(Room r);

    void deleteRoom(Long id);

    Room updateRoom(Room r);
    List<User> getUsersByRoom(long idRoom);
    String assignUserToRoom(long idUser,long idRoom);
    String assignImmobiliereToRoom(long idUser,long idImmo,long idRoom);
    Immobilier getImmobiliereByRoom(long idRoom);


}
