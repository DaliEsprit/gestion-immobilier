package tn.esprit.immobilier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int phoneNumber;
    private String cin;
    private String address;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Notification> notifications;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Jeton jeton;

    String password;
    boolean enabled=true;
}
