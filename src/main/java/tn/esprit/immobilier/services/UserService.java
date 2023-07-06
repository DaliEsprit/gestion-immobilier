package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Jeton;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.entities.enums.JetonStatus;
import tn.esprit.immobilier.entities.enums.RolesTypes;
import tn.esprit.immobilier.repositories.IJetonRepository;
import tn.esprit.immobilier.repositories.IUserRepository;
import tn.esprit.immobilier.security.services.UserDetailsImpl;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IAuthService authService;
    @Autowired
    IJetonRepository jetonRepository;
    @Override
    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(user.getRole()== RolesTypes.ROLE_BUYER) {
            Jeton jeton = new Jeton(0, "", JetonStatus.Basic,0, user, null);
            user.setJeton(jeton);
            jetonRepository.save(user.getJeton());
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> retrieveAllReservation() {
        List<User> listReservation= userRepository.findAll();
        return listReservation;
    }



    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User update(User c) {
        userRepository.save(c);
        return c;
    }

    @Override
    public User getCurrentInfo(){
        UserDetailsImpl userDetails = authService.getCurrent();
        return userRepository.findByEmail(userDetails.getEmail()).orElse(null);
    }
}
