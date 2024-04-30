package fr.uphf.PABLCommandeArticle.dto;
import lombok.*;
import lombok.AllArgsConstructor;



/**
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostArticleRequest {
    private Integer idRestaurant;
    private String ingredients;
    private String nom;
    private Double prix;
    private Integer categorieId;
}
