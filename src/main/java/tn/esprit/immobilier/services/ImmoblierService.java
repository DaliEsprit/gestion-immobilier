package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.repositories.IAttachmentRepository;
import tn.esprit.immobilier.repositories.IImmobilierRepository;

import java.util.List;
@Service
public class ImmoblierService implements IImmobilierService {
    @Autowired
    IImmobilierRepository ImmoRepository;


    @Override
    public List<Immobilier> retrieveAllImmobilier() {
        List<Immobilier> listImmobilier= ImmoRepository.findAll();
        return listImmobilier;
    }
    @Override
    public Immobilier retrieveImmobilierById(Long id) {
        Immobilier ImmobilierObject= ImmoRepository.findById(id).get();
        return ImmobilierObject;
    }

    @Override
    public Long ajouterImmobilier(Immobilier c) {
        ImmoRepository.save(c);
        return c.getId();
    }

    @Override
    public void deleteImmobilier(Long id) {
        ImmoRepository.deleteById(id);

    }

    @Override
    public Immobilier updateImmobilier(Immobilier c) {
        ImmoRepository.save(c);
        return c;
    }

}
