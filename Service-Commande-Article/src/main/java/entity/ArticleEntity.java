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
    private String  prix;

    @Column(nullable = false)
    private String  ingredients;

    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private CategorieEntity id_categorie;






}
