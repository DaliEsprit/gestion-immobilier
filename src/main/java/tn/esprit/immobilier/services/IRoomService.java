package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.*;

import java.util.List;

public interface IRoomService {
    List<Room> retrieveAllRoom();

    Room ajouterRoom(Room r,long userId);

    void deleteRoom(Long id);

    Room updateRoom(Room r);
    List<User> getUsersByRoom(long idRoom);
    String assignUserToRoom(long idUser,long idRoom);
    String assignImmobiliereToRoom(long idUser,long idImmo,long idRoom);
    Immobilier getImmobiliereByRoom(long idRoom);
    List<Room> getListRoomByUser(long idUser);
    Room getRoomById(long idRoom);


}
