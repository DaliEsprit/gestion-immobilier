package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Jeton;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.repositories.IJetonRepository;
import tn.esprit.immobilier.repositories.IRoomRepository;
import tn.esprit.immobilier.repositories.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JetonService implements IJetonService {
   @Autowired
    IJetonRepository jetonRepository;
   @Autowired
    IUserRepository iUserRepository;
   @Autowired
    IRoomRepository iRoomRepository;
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
    public Jeton updateJeton(Jeton j, long idUser, long idRoom) {
        User user = iUserRepository.findById(idUser).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Room room = iRoomRepository.findById(idRoom).orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));
            if (j.getRoom() == null) {
               // j.setRoom(room);
            }
            if (j.getUser() == null) {
                //j.setUser(user);
            }

            Jeton updatedJeton = jetonRepository.save(j);
            return updatedJeton;
        }



    @Override
    public Jeton getJetonByUser(long userId) {
        return jetonRepository.getJetonByUser_Id(userId);
    }

    @Override
    public List<Jeton> getJetonbyRoom(long idRoom) {
        return jetonRepository.getJetonsByRoom_Id(idRoom);
    }
    @Override
    public Jeton updateUserBidAmount(long jetonid, double amount) {
        Jeton jeton=jetonRepository.findById(jetonid).get();
        jeton.setBidValue(amount);
        return jetonRepository.save(jeton);
    }
}