package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Notification;
import tn.esprit.immobilier.entities.Position;

import java.util.List;

public interface InotifService {


    Notification ajouterNotif(Notification notification);

    void deleteNotification(Long id);
    List<Notification> getNotificationsByUser(long id);


}
