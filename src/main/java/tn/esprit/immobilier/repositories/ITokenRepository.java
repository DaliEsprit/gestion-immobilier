package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Token;

import java.util.Optional;

public interface ITokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByTokenAndEnabled(String token,boolean enabled);
}
