package fr.uphf.PABLRestaurant.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRestaurantRequest {
    private Integer id;
    private String nom;
    private String addresse;
    private String telephone;
    private String mail;
}