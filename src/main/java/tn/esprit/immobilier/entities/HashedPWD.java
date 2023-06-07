package tn.esprit.immobilier.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HashedPWD implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long PassId;
    //RISK 90%
    private String Password;

    @Temporal(TemporalType.DATE)
    private Date ChangeDate;

    @JsonBackReference
    @OneToOne
    User user;

}

