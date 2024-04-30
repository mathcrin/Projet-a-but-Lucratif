package fr.uphf.PABLCommandeArticle.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_client", nullable = false)
    private Integer idClient;

    @Column(name = "date_commande", nullable = false)
    private LocalDateTime dateCommande;

    @Column(name = "details", nullable = false)
    private String details;

    @Column(name = "id_restaurant", nullable = false)
    private Integer idRestaurant;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Statut status;

    @ManyToMany
    @JoinTable(
            name = "commande_article",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    private List<Article> articles;

    // Calcul du prix total de la commande
    @Transient // Pour éviter la persistance en base de données
    public double getPrixTotal() {
        double prixTotal = 0.0;
        if (articles != null) {
            for (Article article : articles) {
                prixTotal += article.getPrix();
            }
        }
        return prixTotal;
    }
}
