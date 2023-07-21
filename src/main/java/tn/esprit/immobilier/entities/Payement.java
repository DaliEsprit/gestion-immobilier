package tn.esprit.immobilier.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esprit.immobilier.entities.enums.PaymentStatus;

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
    private float price;
    private PaymentStatus paymentStatus;

    public Payement(Long payementId, String email, int creditCardNumber, int cvc, String date, float price, User acheteur) {
        this.payementId = payementId;
        this.email = email;
        this.creditCardNumber = creditCardNumber;
        this.cvc = cvc;
        this.date = date;
        this.price = price;
        Acheteur = acheteur;
    }

    public Payement() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    User Acheteur;

}
