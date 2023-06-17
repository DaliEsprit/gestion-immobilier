package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Position;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.repositories.IPositionRepository;
import tn.esprit.immobilier.repositories.IRoomRepository;

import java.util.List;
@Service
<<<<<<< HEAD
public class RoomService  implements IRoomService{
=======

public class RoomService  implements IRoomService{
    /*
>>>>>>> 4aab2f57f650960c86baecf1ea80e527bb45779f
    @Autowired
    IRoomRepository roomRepository;


    @Override
<<<<<<< HEAD
    public List<Room> retrieveAllRoom() {
        List<Room> roomList=roomRepository.findAll();
        return roomList;
    }

    @Override
    public Room ajouterRoom(Room r) {
        roomRepository.save(r);
        return r;
=======
    public List<Room> retrieveAllAttachement() {
        List<Room> listPosition= roomRepository.findAll();
        return listPosition;
    }

    @Override
    public Room ajouterAttachement(Room c) {
        roomRepository.save(c);
        return c;
    }

    @Override
    public void deletePosition(Long id) {
        roomRepository.deleteById(id);
>>>>>>> 4aab2f57f650960c86baecf1ea80e527bb45779f

    }

    @Override
<<<<<<< HEAD
    public void deleteRoom(Long id) {
          roomRepository.deleteById(id);
    }

    @Override
    public Room updateRoom(Room r) {
        roomRepository.save(r);
        return r;
    }
=======
    public Room updatePosition(Room c) {
        roomRepository.save(c);
        return c;
    }
}
/
 */
>>>>>>> 4aab2f57f650960c86baecf1ea80e527bb45779f
}
