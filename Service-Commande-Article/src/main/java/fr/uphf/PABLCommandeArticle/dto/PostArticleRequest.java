package fr.uphf.PABLCommandeArticle.dto;
import lombok.*;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

/**
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostArticleRequest {
    private Integer clientId;
    private LocalDateTime dateCommande;
    private Integer restaurantId;
    private String statut;
    private String details;
}
