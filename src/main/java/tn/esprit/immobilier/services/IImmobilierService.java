package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.entities.Position;

import java.util.List;

public interface IImmobilierService {

        List<Immobilier> retrieveAllImmobilier();

    Immobilier ajouterImmobilier(Immobilier c);

        void deleteImmobilier(Long id);

    Immobilier updateImmobilier(Immobilier c);
    }

