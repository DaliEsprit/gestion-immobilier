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
    /*
    @Autowired
    IRoomRepository roomRepository;


    @Override
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

    }

    @Override
    public Room updatePosition(Room c) {
        roomRepository.save(c);
        return c;
    }
}
/
 */
}
