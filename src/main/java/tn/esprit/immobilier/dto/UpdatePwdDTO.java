package tn.esprit.immobilier.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePwdDTO {
    String token;
    String oldPwd;
    String newPwd;
}
