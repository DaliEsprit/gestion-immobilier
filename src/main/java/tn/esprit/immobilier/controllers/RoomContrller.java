package tn.esprit.immobilier.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.entities.Reservation;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.entities.enums.RoomStatus;
import tn.esprit.immobilier.services.IRoomService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/room")
@CrossOrigin("*")
public class RoomContrller {
    @Autowired
    IRoomService roomService;

    @PostMapping("/add-room/{idUser}")
    public Room addRoom(@RequestBody Room r,@PathVariable("idUser") long idUser) {
        return roomService.ajouterRoom(r,idUser);
    }
    // http://localhost:8089/api/immobilier/retrieve-all-immobilier
    @GetMapping("/retrieve-all-room")
    public List<Room> getRoom() {
        List<Room> listRoom = roomService.retrieveAllRoom();
        return listRoom;
    }

    @DeleteMapping("/remove-room/{room-id}")
    public void removeRoom(@PathVariable("room-id") Long roomid) {
        roomService.deleteRoom(roomid);
    }
    @PutMapping("/modify-room")
    @SendTo("/topic/greetings")
    public Room updateRoom(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }
    @GetMapping("/retrieve-users-by-room/{idRoom}")
    public List<User> getUsersByRoom(@PathVariable("idRoom") long idRoom){
        return roomService.getUsersByRoom(idRoom);
    }
    @PutMapping("/assign-user-to-room/{idRoom}/{idUser}")
    public String assignUserToRoom(@PathVariable("idRoom") long idRoom,@PathVariable("idUser") long idUser){
        return roomService.assignUserToRoom(idUser,idRoom);
    }
    @PutMapping("/assign-immobiliere-to-room/{idUser}/{idImmo}/{idRoom}")
    public String assignImmobiliereToRoom(@PathVariable("idUser") long idUser,@PathVariable("idImmo") long idImmo,@PathVariable("idRoom") long idRoom){
        return roomService.assignImmobiliereToRoom(idUser,idImmo,idRoom);
    }
    @GetMapping("/get-immobilier-by-room/{idRoom}")
    public Immobilier getImmobilierByRoom(@PathVariable("idRoom") long idRoom){
        return roomService.getImmobiliereByRoom(idRoom);
    }
    @GetMapping("retrieve-rooms-by-user/{userId}")
    public List<Room> getRoomByUser(@PathVariable("userId") long userId){
        return roomService.getListRoomByUser(userId);
    }
    @GetMapping("retrieve-room-by-id/{idRoom}")
    public Room  getRoombyId(@PathVariable("idRoom") long idRoom){
        return  roomService.getRoomById(idRoom);
    }
    @PutMapping("exit-room/{idUser}/{idRoom}")
    public void ExitRoom(@PathVariable("idUser") long idUser,@PathVariable("idRoom") long idRoom){
        roomService.ExitRoom(idUser,idRoom);
    }
    @PutMapping("update-time-room/{idRoom}/{time}")
    public void updateTimeRoom(@PathVariable("idRoom") long idRoom,@PathVariable("time") long time){
        this.roomService.updateTimeRoom(idRoom,time);
    }
    @GetMapping("get-room-time/{idRoom}")
    public float getRoomTime(@PathVariable("idRoom") long idRoom){
        return roomService.getRoomTime(idRoom);
    }
    @GetMapping("retrieve-user-by-room/{idRoom}")
    public long getUserbyRoom( long idroom){
        return roomService.findUserByRoom(idroom);
    }
    @GetMapping("get-user-by-room-created/{idRoom}")
    public User getUserbyRoomCreated(@PathVariable("idRoom") long idroom){
        return roomService.getUserByRoomCreated(idroom);
    }
    @GetMapping("retrieve-Immobilier-by-room/{idRoom}")
    public Immobilier getImmolierByRoom(@PathVariable("idRoom") long idRoom){
        return roomService.getImmobiliereByRoom(idRoom);
    }
    @PostMapping ("room-reservation/{idUser}/{idImmo}/{idRoom}")
    public Reservation RoomReservation(@PathVariable("idUser") long idUser,@PathVariable("idImmo") long idImmo,@PathVariable("idRoom") long idRoom){
        return roomService.reserveImmobilieretoUserByRoom(idUser,idImmo,idRoom);
    }
    @GetMapping("retrieve-all-reservation-by-room")
    public List<Reservation> retrieveAllReservation(){
        return roomService.retrieveAllReservation();
    }
    @GetMapping("reservationRef/{idRes}")
    public List<Long>  reserRef(@PathVariable("idRes") long idRes){
        return  roomService.retrieveReservationReference(idRes);
    }

}