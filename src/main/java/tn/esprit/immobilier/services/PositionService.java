package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Position;
import tn.esprit.immobilier.repositories.IAttachmentRepository;
import tn.esprit.immobilier.repositories.IPositionRepository;

import java.util.List;
@Service
public class PositionService implements IPositionService{
    @Autowired
    IPositionRepository posRepository;


    @Override
    public List<Position> retrieveAllPosition() {
        List<Position> listPosition= posRepository.findAll();
        return listPosition;
    }

    @Override
    public Position ajouterPosition(Position c) {
        posRepository.save(c);
        return c;
    }

    @Override
    public void deletePosition(Long id) {
        posRepository.deleteById(id);

    }

    @Override
    public Position updatePosition(Position c) {
        posRepository.save(c);
        return c;
    }
}
