package entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "commande")
public class CommandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime date_commande;

    @Column(nullable = false)
    private Integer id_Restaurant;

    @Column(nullable = false)
    private Statut status;

    @Column(nullable = false)
    private String details;

    @ManyToMany
    @JoinColumn(name = "article", nullable = false)
    @Column(nullable = false)
    private List<ArticleEntity> article;
}
