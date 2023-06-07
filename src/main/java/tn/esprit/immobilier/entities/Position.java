package tn.esprit.immobilier.entities;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosition;
    private String log;
    private String lat;

    @OneToOne
    private Immobilier immobilier;

    @OneToOne
    private User Acheteur ;
}
