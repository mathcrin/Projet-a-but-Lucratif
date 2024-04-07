package fr.uphf.PABLCommandeArticle.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String  nom;

    @Column(nullable = false)
    private Integer id_Restaurant;

    @Column(nullable = false)
    private Double  prix;

    @Column(nullable = false)
    private String  ingredients;

    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private CategorieEntity id_categorie;
}
