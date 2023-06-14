package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Position;

import java.util.List;

public interface IPositionService {
    List<Position> retrieveAllAttachement();

    Position ajouterAttachement(Position c);

    void deletePosition(Long id);

    Position updatePosition(Position c);
}
