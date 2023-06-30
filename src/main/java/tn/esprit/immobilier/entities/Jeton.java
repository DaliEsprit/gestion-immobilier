package tn.esprit.immobilier.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Jeton implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idJeton")
    private long idJeton; // Clé primaire
    private int value;
    @OneToOne( mappedBy ="jeton", cascade = CascadeType.REMOVE)
     User user;

}
