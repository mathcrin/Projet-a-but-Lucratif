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
public class PostArticleRequest {
    Long clientId;
    LocalDateTime dateCommande;
    Long restaurantId;
    String statut;
    String details;
}
