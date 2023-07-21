package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.repositories.IAttachmentRepository;
import tn.esprit.immobilier.repositories.IImmobilierRepository;

import java.util.List;
@Service

public class AttachmentService implements IAttachmentService{

    @Autowired
    IAttachmentRepository AttachRepository;
    @Autowired
    IImmobilierRepository immoRepository;



    @Override
    public List<Attachement> retrieveAllAttachement() {
        List<Attachement> listAttachement= AttachRepository.findAll();
        return listAttachement;
    }

    @Override
    public List<Attachement> getAttachementbyIdImmobilier(Long id) {
      List<Attachement> listAttachement= AttachRepository.findAttachementsByImmobilier_Id(id);
        return listAttachement;

    }

    @Override
    public Long  ajouterAttachement(Attachement c) {
        AttachRepository.save(c);
        return c.getIdAttachement();
    }

    @Override
    public void deleteAttachement(Long id) {
        AttachRepository.deleteById(id);

    }

    @Override
    public Attachement deleteAttachementbyName(String name) {

        Attachement att =  AttachRepository.findAttachementsByName(name);
        AttachRepository.deleteById(att.getIdAttachement());
return att;
    }

    @Override
    public Attachement updateAttachement(Attachement c) {
        AttachRepository.save(c);
        return c;
    }
    @Override
    public Attachement assignAttachmenttoImmobilier(Long c, Long im ) {
        Attachement at = AttachRepository.findById(c).get();
        Immobilier imo = immoRepository.findById(im).get();
        at.setImmobilier(imo);
        return AttachRepository.save(at);
    }

}
