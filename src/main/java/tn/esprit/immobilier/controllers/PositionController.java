package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.entities.Position;
import tn.esprit.immobilier.services.IPositionService;
import tn.esprit.immobilier.services.ImmoblierService;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/position")
public class PositionController {
    @Autowired
    IPositionService positionService;
    // http://localhost:8089/api/immobilier/retrieve-all-immobilier
    @GetMapping("/retrieve-all-position")
    public List<Position> getPosition() {
        List<Position> listPosition = positionService.retrieveAllPosition();
        return listPosition;
    }
    @PostMapping("/add-position")
    public Position addPosition(@RequestBody Position c) {
        return
                positionService.ajouterPosition(c);
    }
    @DeleteMapping("/remove-position/{position-id}")
    public void removePosition(@PathVariable("position-id") Long positionId) {
        positionService.deletePosition(positionId);
    }
    @PutMapping("/modify-position")
    public Position updatePosition(@RequestBody Position position) {
        return positionService.updatePosition(position);
    }
}
