package dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 *
 */
@AllArgsConstructor
@Value
public class GetArticleResponse {
    Long id;
    String nom;
    Long restaurantId;
    Object prix;
    String ingredients;
    Long categorieId;
}
