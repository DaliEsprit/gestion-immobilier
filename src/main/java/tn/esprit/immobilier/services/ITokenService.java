package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Token;
import tn.esprit.immobilier.entities.User;

import java.util.List;

public interface ITokenService {

    Token generateAndSave(User user);
}
