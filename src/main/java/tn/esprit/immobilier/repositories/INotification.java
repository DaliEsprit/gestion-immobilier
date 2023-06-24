package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Notification;

public interface INotification extends JpaRepository<Notification,Long> {
}
