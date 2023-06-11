package tn.esprit.immobilier.entities;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPay;
    private Long idImmo;
    private Long idUser;


    @ManyToOne(cascade = CascadeType.ALL)
    User Acheteur;

}
