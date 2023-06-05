package tn.esprit.immobilier.entities;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Room implements Serializable {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int maxBalance;
    private int clientNumber;
    @OneToOne( mappedBy ="room", cascade = CascadeType.REMOVE)
    private Immobilier immobilier;
    @ManyToOne(cascade = CascadeType.ALL)
    Jeton jeton;
    @ManyToMany(mappedBy = "rooms",cascade = CascadeType.REMOVE)
    private List<User> userList;
}
