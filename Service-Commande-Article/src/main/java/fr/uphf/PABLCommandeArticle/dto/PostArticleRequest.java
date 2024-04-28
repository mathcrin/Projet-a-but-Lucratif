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
    private Integer id;
    private Integer idRestaurant;
    private String ingredients;
    private String nom;
    private Double prix;
    private Integer categorieId;
}
