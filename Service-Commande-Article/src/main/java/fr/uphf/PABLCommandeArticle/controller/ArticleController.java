// ArticleController.java
package fr.uphf.PABLCommandeArticle.controller;

import fr.uphf.PABLCommandeArticle.dto.PostArticleRequest;
import fr.uphf.PABLCommandeArticle.dto.GetArticleResponse;
import fr.uphf.PABLCommandeArticle.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/create")
    public Mono<ResponseEntity<GetArticleResponse>> createArticle(@RequestBody PostArticleRequest request) {
        return articleService.createArticle(request)
                .map(response -> new ResponseEntity<>(response, HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<GetArticleResponse>> getArticle(@PathVariable Integer id) {
        return articleService.getArticle(id)
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}