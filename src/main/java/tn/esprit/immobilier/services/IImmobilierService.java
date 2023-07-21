package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.entities.Position;

import java.util.List;

public interface IImmobilierService {

        List<Immobilier> retrieveAllImmobilier();
    Immobilier retrieveImmobilierById(Long id);
    Long  ajouterImmobilier(Immobilier c, Long id);

        void deleteImmobilier(Long id);

    Long updateImmobilier(Immobilier c, Long id);

}

