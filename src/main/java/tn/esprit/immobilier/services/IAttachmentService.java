package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Attachement;

import java.util.List;

public interface IAttachmentService {
    List<Attachement> retrieveAllAttachement();

    Long ajouterAttachement(Attachement c);

    void deleteAttachement(Long id);

    Attachement updateAttachement(Attachement c);
    List<Attachement> getAttachementbyIdImmobilier(Long id);
    public Attachement assignAttachmenttoImmobilier(Long c, Long im);
}
