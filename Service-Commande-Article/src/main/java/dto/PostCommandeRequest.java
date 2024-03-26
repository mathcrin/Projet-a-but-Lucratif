package dto;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 *
 */
@AllArgsConstructor
@Value
public class PostCommandeRequest {
    String nom;
    Long restaurantId;
    double prix;
    String ingredients;
    Long categorieId;
}

