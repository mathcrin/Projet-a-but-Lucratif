package DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRestaurantResponse {
    private Long id;
    private String nom;
    private String addresse;
    private String telephone;
}
