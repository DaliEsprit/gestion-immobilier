
package tn.esprit.immobilier.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.immobilier.entities.User;
import tn.esprit.immobilier.repositories.IUserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  IUserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
   // System.out.println(user);
    return UserDetailsImpl.build(user);
  }

}
