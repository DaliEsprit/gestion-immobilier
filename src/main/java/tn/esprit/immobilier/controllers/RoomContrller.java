package tn.esprit.immobilier.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Immobilier;
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

    @PostMapping("/add-room")
    public Room addRoom(@RequestBody Room r) {
        return roomService.ajouterRoom(r);
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

}
