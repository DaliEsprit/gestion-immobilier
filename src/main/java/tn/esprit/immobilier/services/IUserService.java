package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);

    List<User> retrieveAllReservation();

    void delete(Long id);

    User update(User c);
}
