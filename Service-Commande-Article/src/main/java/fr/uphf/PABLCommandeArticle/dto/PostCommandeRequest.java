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
public class PostCommandeRequest {
    private String nom;
    private Long restaurantId;
    private Double prix;
    private String ingredients;
    private Long categorieId;
}

