package fr.uphf.PABLCommandeArticle.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO pour la réponse à la récupération d'une commande
 */
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
}