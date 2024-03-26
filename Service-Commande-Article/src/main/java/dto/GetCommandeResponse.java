package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * DTO pour la réponse à la récupération d'une commande
 */
@AllArgsConstructor
@Value
public class GetCommandeResponse {
    Long id;
    Long clientId;
    LocalDateTime dateCommande;
    Long restaurantId;
    String statut;
    String details;
}