package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Notification;
import tn.esprit.immobilier.entities.Position;
import tn.esprit.immobilier.repositories.INotification;
import tn.esprit.immobilier.repositories.IPositionRepository;

import java.util.List;

@Service
public class NotifService implements InotifService {
    @Autowired
    INotification inotifrepository;




    @Override
    public Notification ajouterNotif(Notification notification) {
        inotifrepository.save(notification);
        return notification;

    }

    @Override
    public void deleteNotification(Long id) {
        inotifrepository.deleteById(id);

    }


}
