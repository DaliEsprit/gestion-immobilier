package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Jeton;
import tn.esprit.immobilier.repositories.IJetonRepository;

import java.util.List;
@Service
public class JetonService implements IJetonService {
   @Autowired
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

    @Override
    public List<Jeton> getJetonbyRoom(long idRoom) {
        return jetonRepository.getJetonsByRoom_Id(idRoom);
    }
}