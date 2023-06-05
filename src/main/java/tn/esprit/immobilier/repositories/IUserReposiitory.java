package tn.esprit.immobilier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.immobilier.entities.User;

public interface IUserReposiitory extends JpaRepository<User,Long> {
}
