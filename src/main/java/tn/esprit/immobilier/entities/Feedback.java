package tn.esprit.immobilier.entities;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFb;
    private String ScreenType;
    private String Description;


    @ManyToOne(cascade = CascadeType.ALL)
    User Acheteur;
    
}
