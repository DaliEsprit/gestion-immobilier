package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Payement;
import tn.esprit.immobilier.repositories.IPayementRepository;

import java.util.List;

@Service

public class PayementService implements IPayementService{
    @Autowired
    IPayementRepository PayRepository;


    @Override
    public List<Payement> retrieveAllPayement() {
        List<Payement> listPayement= PayRepository.findAll();
        return listPayement;
    }

    @Override
    public Payement ajouterPayement(Payement p) {
        PayRepository.save(p);
        return p;
    }

    @Override
    public void deletePayement(Long id) {
        PayRepository.deleteById(id);

    }

    @Override
    public Payement updatePayement(Payement p) {
        PayRepository.save(p);
        return p;
    }
}
