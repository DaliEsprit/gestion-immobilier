package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.immobilier.entities.Notification;
import tn.esprit.immobilier.entities.User;

import java.util.List;

public interface INotification extends JpaRepository<Notification,Long> {
    @Query(value = "select * from Notification not  where not.user.id=?1",nativeQuery = true)
    List<Notification> getNotificationbyUserId(long userId);
}
