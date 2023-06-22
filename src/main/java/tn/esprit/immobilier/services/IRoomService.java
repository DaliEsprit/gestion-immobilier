package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Room;

import java.util.List;

public interface IRoomService {
    public Room addRoom();
    public Room findRoom(long id);
    public int deleteRoom(long id);

}
