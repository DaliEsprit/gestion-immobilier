package tn.esprit.immobilier.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString
public class Payement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payementId;
    private String email;
    private int creditCardNumber;
    private int cvc;
    private String date;

    public Payement(Long payementId, String email, int creditCardNumber, int cvc, String date, User acheteur) {
        this.payementId = payementId;
        this.email = email;
        this.creditCardNumber = creditCardNumber;
        this.cvc = cvc;
        this.date = date;
        Acheteur = acheteur;
    }

    public Payement() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    User Acheteur;

}
