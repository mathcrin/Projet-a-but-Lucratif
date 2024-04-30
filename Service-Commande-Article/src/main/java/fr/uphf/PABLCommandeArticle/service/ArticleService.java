
package fr.uphf.PABLCommandeArticle.service;

import fr.uphf.PABLCommandeArticle.dto.PostArticleRequest;
import fr.uphf.PABLCommandeArticle.dto.GetArticleResponse;
import fr.uphf.PABLCommandeArticle.entity.Article;
import fr.uphf.PABLCommandeArticle.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Mono<GetArticleResponse> createArticle(PostArticleRequest request) {
        Article article = new Article();
        // Set the properties of the article from the request here
        Article savedArticle = articleRepository.save(article);
        return Mono.just(new GetArticleResponse(savedArticle.getId(), savedArticle.getNom(), savedArticle.getId_Restaurant(), savedArticle.getPrix(), savedArticle.getIngredients(), savedArticle.getCategorie().getNom()));
    }

    public Mono<GetArticleResponse> getArticle(Integer id) {
        return Mono.justOrEmpty(articleRepository.findById(id)
                .map(article -> new GetArticleResponse(article.getId(), article.getNom(), article.getId_Restaurant(), article.getPrix(), article.getIngredients(), article.getCategorie().getNom())));
    }

    public Mono<List<Article>> getArticles() {
        return Mono.just(articleRepository.findAll());
    }
}