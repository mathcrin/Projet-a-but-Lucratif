package fr.uphf.PABLCommandeArticle.repository;

import fr.uphf.PABLCommandeArticle.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
}