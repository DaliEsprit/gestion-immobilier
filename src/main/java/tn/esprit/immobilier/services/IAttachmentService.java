package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Attachement;

import java.util.List;

public interface IAttachmentService {
    List<Attachement> retrieveAllAttachement();

    Attachement ajouterAttachement(Attachement c);

    void deleteAttachement(Long id);

    Attachement updateAttachement(Attachement c);

}
