package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Jeton;
import tn.esprit.immobilier.repositories.IJetonRepository;

import java.util.List;

public class JetonService implements IJetonService {
    IJetonRepository jetonRepository;
    @Override
    public List<Jeton> retrieveAllJeton() {
        List<Jeton> jeton = jetonRepository.findAll();
        return jeton;
    }

    @Override
    public Jeton ajouterJeton(Jeton j) {
         jetonRepository.save(j);
        return j;
    }

    @Override
    public void deleteJeton(Long id) {
      jetonRepository.deleteById(id);
    }

    @Override
    public Jeton updateJeton(Jeton j) {
        jetonRepository.save(j);
        return j;
    }

    @Override
    public Jeton getJetonByUser(long userId) {
        return jetonRepository.getJetonByUser_Id(userId);
    }
}