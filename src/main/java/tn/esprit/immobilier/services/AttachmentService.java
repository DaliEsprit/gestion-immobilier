package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.repositories.IAttachmentRepository;

import java.util.List;
@Service

public class AttachmentService implements IAttachmentService{
    @Autowired
    IAttachmentRepository AttachRepository;


    @Override
    public List<Attachement> retrieveAllAttachement() {
        List<Attachement> listAttachement= AttachRepository.findAll();
        return listAttachement;
    }

    @Override
    public Attachement ajouterAttachement(Attachement c) {
        AttachRepository.save(c);
        return c;
    }

    @Override
    public void deleteAttachement(Long id) {
        AttachRepository.deleteById(id);

    }

    @Override
    public Attachement updateAttachement(Attachement c) {
        AttachRepository.save(c);
        return c;
    }
}
