package fr.uphf.PABLCommandeArticle.dto;
import lombok.*;

import java.time.LocalDateTime;

/**
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetArticleResponse {
    private Integer id;
    private String nom;
    private Integer restaurantId;
    private Double prix;
    private String ingredients;
    private Integer categorieId;
}
