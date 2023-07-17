package tn.esprit.immobilier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esprit.immobilier.entities.enums.ImmoStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Immobilier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ImmoStatus status;
    private String etat;
    private String description;
    private Long price;
    @ManyToOne
    private User user;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Room room;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="immobilier")
    List<Attachement> attachementList;

}
