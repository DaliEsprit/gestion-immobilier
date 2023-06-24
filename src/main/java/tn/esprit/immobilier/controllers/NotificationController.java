package tn.esprit.immobilier.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.immobilier.entities.Notification;
import tn.esprit.immobilier.entities.Position;
import tn.esprit.immobilier.services.InotifService;

public class NotificationController {
    InotifService inotifService;


    @PostMapping("/add-notif")
    public Notification addNotif(@RequestBody Notification n) {
        return inotifService.ajouterNotif(n);
    }
    @DeleteMapping("/remove-notif/{notif-id}")
    public void removeNotif(@PathVariable("notif-id") Long idNotif) {
        inotifService.deleteNotification(idNotif);
    }
}
