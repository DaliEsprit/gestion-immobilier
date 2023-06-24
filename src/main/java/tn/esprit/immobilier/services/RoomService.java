package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Position;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.repositories.IPositionRepository;
import tn.esprit.immobilier.repositories.IRoomRepository;

import java.util.List;
@Service

public class RoomService  implements IRoomService{


    @Autowired
    IRoomRepository roomRepository;


    @Override
    public List<Room> retrieveAllRoom() {
        List<Room> roomList=roomRepository.findAll();
        return roomList;
    }

    @Override
    public Room ajouterRoom(Room r) {
        roomRepository.save(r);
        return r;
    }
    public List<Room> retrieveAllAttachement() {
        List<Room> listPosition= roomRepository.findAll();
        return listPosition;
    }



    @Override
    public void deleteRoom(Long id) {
          roomRepository.deleteById(id);
    }

    @Override
    public Room updateRoom(Room r) {
        roomRepository.save(r);
        return r;
    }

    public Room updatePosition(Room c) {
        roomRepository.save(c);
        return c;

    }
}


