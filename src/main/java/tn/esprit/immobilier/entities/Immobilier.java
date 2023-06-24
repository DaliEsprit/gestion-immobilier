package tn.esprit.immobilier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esprit.immobilier.entities.enums.ImmoStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Immobilier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ImmoStatus status;
    private String etat;
    private String description;

    @ManyToOne
    private User seller;
    @ManyToOne
    private User buyer;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Room room;

}
