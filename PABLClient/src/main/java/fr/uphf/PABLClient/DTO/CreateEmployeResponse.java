package fr.uphf.PABLClient.DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String addresse;
    private String mail;
    private String telephone;
}
