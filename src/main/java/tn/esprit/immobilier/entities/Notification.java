package tn.esprit.immobilier.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.immobilier.entities.enums.RolesTypes;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    
    @ElementCollection
    @Column(name="roles")
    private List<RolesTypes> roles;
    

	public Notification(String title, String message, List<RolesTypes> roles) {
		super();
		this.title = title;
		this.message = message;
		this.roles = roles;
	}
    


}
