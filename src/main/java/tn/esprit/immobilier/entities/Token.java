package tn.esprit.immobilier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esprit.immobilier.entities.enums.RolesTypes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Token implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @ManyToOne
    private User user;
    boolean enabled=true;
}
