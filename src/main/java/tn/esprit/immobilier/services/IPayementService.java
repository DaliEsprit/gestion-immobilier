package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Payement;

import java.util.List;

public interface IPayementService {
    List<Payement> retrieveAllPayement();

    Payement ajouterPayement(Payement p);

    void deletePayement(Long id);

    Payement updatePayement(Payement p);

}
