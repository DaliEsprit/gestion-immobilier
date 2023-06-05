package tn.esprit.immobilier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    private int age;
    private int phoneNumber;
    private String cin;
    private String address;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Jeton jeton;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Room> rooms;
}
