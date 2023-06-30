package tn.esprit.immobilier.services;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Notification;
import tn.esprit.immobilier.entities.Position;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.repositories.INotification;
import tn.esprit.immobilier.repositories.IPositionRepository;
import tn.esprit.immobilier.repositories.IRoomRepository;

import java.util.List;

@Service
public class NotifService implements InotifService {
    @Autowired
    INotification inotifrepository;
    IRoomRepository iRoomRepository;




    @Override
    public Notification ajouterNotif(Notification notification) {
        inotifrepository.save(notification);
        iRoomRepository.save(new Room(25252L,250,3,null,null,null));
        return notification;

    }

    @Override
    public void deleteNotification(Long id) {
        inotifrepository.deleteById(id);

    }

    @Override
    public List<Notification> getNotificationsByUser(long id) {
        return inotifrepository.getNotificationbyUserId(id);
    }


}
