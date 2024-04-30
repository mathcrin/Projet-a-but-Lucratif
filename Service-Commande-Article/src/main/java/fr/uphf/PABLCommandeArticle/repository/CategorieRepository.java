package fr.uphf.PABLCommandeArticle.repository;

import fr.uphf.PABLCommandeArticle.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
