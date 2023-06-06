package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Immobilier;

public interface IImmobilierService {

    Immobilier ajouterImmobilier(Immobilier bf);
    Immobilier GetImmobilier(Immobilier bf);
    Immobilier SupprimerImmobilier(Long id);
}
