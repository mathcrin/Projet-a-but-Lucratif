package DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRestaurantRequest {
    private String nom;
    private String addresse;
    private String telephone;
}