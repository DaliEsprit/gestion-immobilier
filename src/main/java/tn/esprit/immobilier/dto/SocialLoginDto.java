package tn.esprit.immobilier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialLoginDto {
    private String email;
    private String firstName;
    private String id;
    private String idToken;
    private String lastName;
    private String name;
    private String photoUrl;
    private String provider;
}
