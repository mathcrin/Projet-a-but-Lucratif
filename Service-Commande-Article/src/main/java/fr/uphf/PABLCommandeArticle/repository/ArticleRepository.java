package fr.uphf.PABLCommandeArticle.repository;

import fr.uphf.PABLCommandeArticle.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}