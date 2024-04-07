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
    private Integer clientId;
    private LocalDateTime dateCommande;
    private Integer restaurantId;
    private String statut;
    private String details;
}