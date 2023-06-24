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

>>>>>>> 5da6af37e6f214d95d17d6488b0f45e9264bcba4
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
<<<<<<< HEAD
=======

>>>>>>> 5da6af37e6f214d95d17d6488b0f45e9264bcba4
    public List<Room> retrieveAllAttachement() {
        List<Room> listPosition= roomRepository.findAll();
        return listPosition;
    }

<<<<<<< HEAD


=======
>>>>>>> 5da6af37e6f214d95d17d6488b0f45e9264bcba4
    @Override
    public void deleteRoom(Long id) {
          roomRepository.deleteById(id);
    }

    @Override
    public Room updateRoom(Room r) {
        roomRepository.save(r);
        return r;
    }
<<<<<<< HEAD

=======
>>>>>>> 5da6af37e6f214d95d17d6488b0f45e9264bcba4
    public Room updatePosition(Room c) {
        roomRepository.save(c);
        return c;

    }
}
<<<<<<< HEAD


=======
>>>>>>> 5da6af37e6f214d95d17d6488b0f45e9264bcba4
