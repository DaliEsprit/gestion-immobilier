package tn.esprit.immobilier.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    private Date datereservation;

    @OneToOne
    private Immobilier immobilier;
    @ManyToOne(cascade = CascadeType.ALL)
    User user;


}
