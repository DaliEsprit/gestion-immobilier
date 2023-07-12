package tn.esprit.immobilier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.immobilier.entities.enums.JetonStatus;

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
    private String value;
    private JetonStatus jetonStatus;
    private double bidValue;
    @OneToOne(  cascade = CascadeType.ALL)
    @JsonIgnore
     User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Room room;
}
