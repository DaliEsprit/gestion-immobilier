package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Token;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.repositories.ITokenRepository;

import java.util.UUID;

@Service
public class TokenService implements ITokenService{

    @Autowired
    ITokenRepository tokenRepository;

    @Override
    public Token generateAndSave(User user){
        UUID uuid = UUID.randomUUID();
        Token token = new Token();
        token.setToken(uuid.toString());
        token.setUser(user);
        return tokenRepository.save(token);
    }
}
