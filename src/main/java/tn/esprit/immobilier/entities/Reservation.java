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
    private Long idAcheteur;
    private Long idVendeur;

    @OneToOne
    private Immobilier immobilier;
    @ManyToOne(cascade = CascadeType.ALL)
    User Acheteur;
    @OneToOne
    private Room rooms;
}
