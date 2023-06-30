package tn.esprit.immobilier.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Notification;
import tn.esprit.immobilier.entities.Position;
import tn.esprit.immobilier.services.InotifService;

import java.util.List;

@RestController
@RequestMapping("/notification")
@CrossOrigin("*")
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

    @GetMapping("getNotificationsbyUser/{userId}")
    public List<Notification> getNotificationByUserId(@PathVariable("userId") long userId){
        return inotifService.getNotificationsByUser(userId);
    }
}
