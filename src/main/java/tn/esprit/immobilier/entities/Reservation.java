package tn.esprit.immobilier.entities;

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
    @OneToOne
    private Immobilier immobilier;
    @ManyToOne(cascade = CascadeType.ALL)
    User Acheteur;
    @ManyToOne(cascade = CascadeType.ALL)
    User Vendeur;
    @OneToOne
    private Room rooms;
}
