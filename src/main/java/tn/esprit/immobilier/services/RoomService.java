package tn.esprit.immobilier.services;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.immobilier.entities.*;
import tn.esprit.immobilier.entities.enums.JetonStatus;
import tn.esprit.immobilier.entities.enums.RolesTypes;
import tn.esprit.immobilier.entities.enums.RoomStatus;
import tn.esprit.immobilier.repositories.*;
import tn.esprit.immobilier.security.jwt.AuthTokenFilter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service

public class RoomService  implements IRoomService{

     @Autowired
     IImmobilierRepository iImmobilierRepository;
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
    public Room ajouterRoom(Room r,long userId) {
        User user=iUserRepository.findById(userId).get();
        if(user.getRole()==RolesTypes.ROLE_SELLER||user.getRole()==RolesTypes.ROLE_ADMIN) {
            roomStatusUpdate(r);
            r.setClientNumber(0);
            r.setRoomStatus(RoomStatus.NotStarted);
            r.setUser(user);
            user.getRoomList().add(r);
            user.setRoomList(user.getRoomList());
            iUserRepository.save(user);
            return r;
        }
        return null;
    }
    public List<Room> retrieveAllAttachement() {
        List<Room> listPosition= roomRepository.findAll();
        return listPosition;
    }

    @Override
    public void deleteRoom(Long id) {
        Room room =roomRepository.findById(id).get();
        room.setUser(null);
        roomRepository.delete(room);
    }

    @Override
    public Room updateRoom(Room r) {
        roomStatusUpdate(r);
        r.setClientNumber(getUsersByRoom(r.getId()).size());
        roomRepository.save(r);
        return r;
    }
    @MessageMapping("/chat")
    @SendTo("/topic/users")
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
            if(user.getRoom()!=null) {
                if (user.getRoom().getId() == room.getId()) {
                    user.setJeton(new Jeton(user.getJeton().getIdJeton(), room.getJetonValue(), user.getJeton().getJetonStatus(), user.getJeton().getBidValue(), user, room));
                }
                else
                    user.setJeton(new Jeton(user.getJeton().getIdJeton(),room.getJetonValue(),user.getJeton().getJetonStatus(),room.getMinAmount(),user,room));

            }
            else
            user.setJeton(new Jeton(user.getJeton().getIdJeton(),room.getJetonValue(),user.getJeton().getJetonStatus(),room.getMinAmount(),user,room));
            iJetonRepository.save(user.getJeton());
        }
        else if (user.getJeton().getJetonStatus()== JetonStatus.Premieum &&(room.isPremiumRoom() && !room.isGoldRoom())||(!room.isPremiumRoom()&& !room.isGoldRoom())){
            if(user.getRoom()!=null){
                if(user.getRoom().getId()==room.getId()){
                    user.setJeton(new Jeton(user.getJeton().getIdJeton(),room.getJetonValue(),user.getJeton().getJetonStatus(),user.getJeton().getBidValue(),user,room));
                }
                else
                    user.setJeton(new Jeton(user.getJeton().getIdJeton(),room.getJetonValue(),user.getJeton().getJetonStatus(),room.getMinAmount(),user,room));
            }
            else
                user.setJeton(new Jeton(user.getJeton().getIdJeton(),room.getJetonValue(),user.getJeton().getJetonStatus(),room.getMinAmount(),user,room));
            iJetonRepository.save(user.getJeton());
        }
        else if(user.getJeton().getJetonStatus()== JetonStatus.Basic && !room.isPremiumRoom()&& !room.isGoldRoom()){
            if(user.getRoom()!=null) {
                if (user.getRoom().getId() == room.getId()) {
                    user.setJeton(new Jeton(user.getJeton().getIdJeton(), room.getJetonValue(), user.getJeton().getJetonStatus(), user.getJeton().getBidValue(), user, room));
                }
                else
                    user.setJeton(new Jeton(user.getJeton().getIdJeton(),room.getJetonValue(),user.getJeton().getJetonStatus(),room.getMinAmount(),user,room));
            }
            else
                user.setJeton(new Jeton(user.getJeton().getIdJeton(),room.getJetonValue(),user.getJeton().getJetonStatus(),room.getMinAmount(),user,room));
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

    @Override
    public String assignImmobiliereToRoom(long idUser,long idImmo, long idRoom) {
        JSONObject response = new JSONObject();
        User user=iUserRepository.findById(idUser).get();
        if(user.getRole()== RolesTypes.ROLE_SELLER ||user.getRole()==RolesTypes.ROLE_ADMIN  ) {
            Immobilier immobilier = iImmobilierRepository.findById(idImmo).get();
            Room room = roomRepository.findById(idRoom).get();
            room.setImmobilier(immobilier);
            roomRepository.save(room);
            immobilier.setRoom(room);
            immobilier.setUser(user);
            iImmobilierRepository.save(immobilier);
            return response.put("message", "Success").toString();
        }
        return response.put("message", "failed").toString();
    }

    @Override
    public Immobilier getImmobiliereByRoom(long idRoom) {
        return iImmobilierRepository.getImmobilierByRoom_Id(idRoom);
    }

    @Override
    public List<Room> getListRoomByUser(long idUser) {
        return roomRepository.getRoomsByUser_Id(idUser);
    }

    @Override
    public Room getRoomById(long idRoom) {
        return roomRepository.getRoomById(idRoom);
    }

    @Override
    public void ExitRoom(long idUser,long idRoom) {
        Room room=roomRepository.findById(idRoom).get();
        User user=iUserRepository.findById(idUser).get();
        user.setRoom(null);
        room.setClientNumber(room.getClientNumber()-1);
        if(room.getClientNumber()==-1)
            room.setClientNumber(0);
        iUserRepository.save(user);
        roomRepository.save(room);
    }

    @Override
    public void updateTimeRoom(long idRoom,long timeRoom) {
        Room room=roomRepository.findById(idRoom).get();
        room.setTimeRoom(timeRoom);
        roomRepository.save(room);
    }

    @Override
    public float getRoomTime(long idRoom) {
        Room room=roomRepository.findById(idRoom).get();
        return room.getTimeRoom();
    }


    public Room updatePosition(Room c) {
        roomRepository.save(c);
        return c;

    }
}
