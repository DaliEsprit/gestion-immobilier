package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.User;

import java.util.Optional;

public interface IUserReposiitory extends JpaRepository<User,Long> {
   Optional<User> findByEmail(String email);
}
