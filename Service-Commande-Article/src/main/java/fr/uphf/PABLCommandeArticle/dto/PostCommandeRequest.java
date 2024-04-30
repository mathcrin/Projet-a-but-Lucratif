package fr.uphf.PABLCommandeArticle.dto;
import lombok.*;
import lombok.AllArgsConstructor;
import fr.uphf.PABLCommandeArticle.entity.Categorie;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCommandeRequest {
    private Integer idClient;
    private LocalDateTime dateCommande;
    private String details;
    private Integer idRestaurant;
    private String status;
    private List<Integer> articles;
}

