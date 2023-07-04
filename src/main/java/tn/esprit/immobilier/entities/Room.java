package tn.esprit.immobilier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int minAmount;
    private int clientNumber;
    private String jetonValue;
    private boolean premiumRoom;
    private boolean goldRoom;
    @OneToOne( mappedBy ="room", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Immobilier immobilier;

    @OneToMany(mappedBy = "room",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<User> userList;
}
