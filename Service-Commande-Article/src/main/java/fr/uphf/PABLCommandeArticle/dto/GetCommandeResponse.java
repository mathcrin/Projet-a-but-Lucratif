package fr.uphf.PABLCommandeArticle.dto;

import fr.uphf.PABLCommandeArticle.entity.Statut;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCommandeResponse {
    private Integer id;
    private Integer idClient;
    private LocalDateTime dateCommande;
    private Integer idRestaurant;
    private String status;
    private String details;
    private String articles;

    // Utilisez un des constructeurs existants
    public GetCommandeResponse(Integer id, Integer idClient, LocalDateTime dateCommande, Integer idRestaurant, Statut status, String details, String articles) {
        this.id = id;
        this.idClient = idClient;
        this.dateCommande = dateCommande;
        this.idRestaurant = idRestaurant;
        this.status = status.toString(); // Convertissez l'enum Statut en String
        this.details = details;
        this.articles = articles;
    }
}
