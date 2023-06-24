package tn.esprit.immobilier.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.services.IRoomService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/room")
public class RoomContrller {
    IRoomService roomService;

    @PostMapping("/add-room")
    public Room addRoom(@RequestBody Room r) {
        return
                roomService.ajouterRoom(r);
    }
    @Autowired

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
    public Room updateRoom(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }

}
