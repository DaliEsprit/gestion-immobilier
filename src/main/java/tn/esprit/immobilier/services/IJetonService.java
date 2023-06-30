package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Jeton;
import tn.esprit.immobilier.entities.Room;

import java.util.List;

public interface IJetonService {
    List<Jeton> retrieveAllJeton();

    Jeton ajouterJeton(Jeton j);

    void deleteJeton(Long id);

    Jeton updateJeton(Jeton j);

    Jeton getJetonByUser(long userId);

}
