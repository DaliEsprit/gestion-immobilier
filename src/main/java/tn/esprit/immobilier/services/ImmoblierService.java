package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.repositories.IAttachmentRepository;
import tn.esprit.immobilier.repositories.IImmobilierRepository;
import tn.esprit.immobilier.repositories.IUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImmoblierService implements IImmobilierService {
    @Autowired
    IImmobilierRepository ImmoRepository;
    @Autowired
    IUserRepository UserRepository;

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
    public Long ajouterImmobilier(Immobilier c, Long id) {
        User user = UserRepository.getById(id);
        c.setUser(user);
        ImmoRepository.save(c);
        return c.getId();
    }

    @Override
    public void deleteImmobilier(Long id) {
        ImmoRepository.deleteById(id);

    }

    @Override
    public Long updateImmobilier(Immobilier c, Long id) {
        Optional<Immobilier> tutorialData = ImmoRepository.findById(id);

        if (tutorialData.isPresent()) {
            Immobilier _tutorial = tutorialData.get();
            _tutorial.setDescription(c.getDescription());
            _tutorial.setEtat(c.getEtat());
            _tutorial.setPrice(c.getPrice());
            ImmoRepository.save(_tutorial);
            return id ;
        } else {
            return id;
        }

    }

    @Override
    public List<Immobilier> retrieveImmobileresByUser(long iddUser) {
        User user=UserRepository.findById(iddUser).get();
        return user.getImmobiliers();
        }

    @Override
    public Immobilier getImmoByName(String name) {
        return ImmoRepository.getImmobilierByName(name);
    }


}
