package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Jeton;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.entities.enums.JetonStatus;

import java.util.List;

public interface IJetonService {
    List<Jeton> retrieveAllJeton();

    Jeton ajouterJeton(Jeton j);

    void deleteJeton(Long id);

    Jeton updateJeton(Jeton j,long iduser,long idRoom);

    Jeton getJetonByUser(long userId);
    List<Jeton> getJetonbyRoom(long idRoom);
    Jeton updateUserBidAmount(long jetonId,double amount);
    Jeton updateJetonStatus(long jetonId, JetonStatus jetonStatus);
}
