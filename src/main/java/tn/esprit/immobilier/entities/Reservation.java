package tn.esprit.immobilier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private String dateReservation;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Immobilier immobilier;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    User user;
    @OneToOne
    @JsonIgnore
    private Room rooms;
}
