package tn.esprit.immobilier.services;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.immobilier.entities.*;
import tn.esprit.immobilier.entities.enums.JetonStatus;
import tn.esprit.immobilier.entities.enums.RoomStatus;
import tn.esprit.immobilier.repositories.*;
import tn.esprit.immobilier.security.jwt.AuthTokenFilter;

import java.util.List;
import java.util.Random;

@Service

public class RoomService  implements IRoomService{





    @Autowired
    IRoomRepository roomRepository;
    INotification iNotification;

    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    private IJetonRepository iJetonRepository;

    @Override
    public List<Room> retrieveAllRoom() {
        List<Room> roomList=roomRepository.findAll();
        return roomList;
    }

    public void roomStatusUpdate(Room r){

        if(r.isGoldRoom() || r.isPremiumRoom()) {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            int length = 20;
            Random random = new Random();
            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(characters.length());
                char randomChar = characters.charAt(randomIndex);
                sb.append(randomChar);
            }
            r.setJetonValue(sb.toString());
        }
        else {
            r.setJetonValue("");
        }
    }
    @Override
    public Room ajouterRoom(Room r) {
        roomStatusUpdate(r);
        r.setClientNumber(0);
        r.setRoomStatus(RoomStatus.NotStarted);
        roomRepository.save(r);
        return r;
    }
    public List<Room> retrieveAllAttachement() {
        List<Room> listPosition= roomRepository.findAll();
        return listPosition;
    }

    @Override
    public void deleteRoom(Long id) {
          roomRepository.deleteById(id);
    }

    @Override
    public Room updateRoom(Room r) {
        roomStatusUpdate(r);
        r.setClientNumber(getUsersByRoom(r.getId()).size());
        roomRepository.save(r);
        return r;
    }

    @Override
    public List<User> getUsersByRoom(long idRoom) {
        return iUserRepository.getUsersByRoom_Id(idRoom);
    }

    @Override
    public String assignUserToRoom(long idUser, long idRoom) {
        User user=iUserRepository.findById(idUser).get();
        Room room=roomRepository.findById(idRoom).get();
        JSONObject response = new JSONObject();
        if(user.getJeton().getJetonStatus()== JetonStatus.Gold) {
            user.setJeton(new Jeton(user.getJeton().getIdJeton(),room.getJetonValue(),user.getJeton().getJetonStatus(),user,room));
            iJetonRepository.save(user.getJeton());
        }
        else if (user.getJeton().getJetonStatus()== JetonStatus.Premieum && room.isPremiumRoom() && !room.isGoldRoom()){
            user.setJeton(new Jeton(user.getJeton().getIdJeton(),room.getJetonValue(),user.getJeton().getJetonStatus(),user,room));
            iJetonRepository.save(user.getJeton());
        }
        else if(user.getJeton().getJetonStatus()== JetonStatus.Basic && !room.isPremiumRoom()&& !room.isGoldRoom()){
            user.setJeton(new Jeton(user.getJeton().getIdJeton(),room.getJetonValue(),user.getJeton().getJetonStatus(),user,room));
            iJetonRepository.save(user.getJeton());
        }
        if(user.getJeton().getValue()==room.getJetonValue()) {
                room.getUserList().add(user);
                user.setRoom(room);
                iUserRepository.save(user);
                roomRepository.save(room);
            response.put("message", "Access Granted");
                return response.toString();
            }
        response.put("message", "Access Refused");
        return response.toString();
    }


    public Room updatePosition(Room c) {
        roomRepository.save(c);
        return c;

    }
}
