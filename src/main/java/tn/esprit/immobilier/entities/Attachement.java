package tn.esprit.immobilier.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esprit.immobilier.entities.enums.ImmoStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Attachement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAttachement;
    private String name;
    private String path;

    @ManyToOne
    Immobilier immobilier;
}
