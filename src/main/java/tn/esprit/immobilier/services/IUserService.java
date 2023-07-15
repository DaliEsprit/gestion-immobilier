package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.security.jwt.JwtResponse;

import java.util.List;

public interface IUserService {
    JwtResponse createUser(User user);

    List<User> retrieveAllReservation();

    void delete(Long id);

    User update(User c);

    User getCurrentInfo();
}
