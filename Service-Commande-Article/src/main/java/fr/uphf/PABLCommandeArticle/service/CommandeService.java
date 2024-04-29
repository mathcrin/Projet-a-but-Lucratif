package fr.uphf.PABLCommandeArticle.service;

import fr.uphf.PABLCommandeArticle.dto.PostCommandeRequest;
import fr.uphf.PABLCommandeArticle.dto.GetCommandeResponse;
import fr.uphf.PABLCommandeArticle.entity.Commande;
import fr.uphf.PABLCommandeArticle.entity.Statut;
import fr.uphf.PABLCommandeArticle.repository.ArticleRepository;
import fr.uphf.PABLCommandeArticle.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public Mono<GetCommandeResponse> createCommande(PostCommandeRequest request) {
        System.out.println("CommandeService: createCommande: request: " + request.getArticles());
        Commande commande = Commande.builder()
                .idClient(request.getIdClient())
                .dateCommande(request.getDateCommande())
                .idRestaurant(request.getIdRestaurant())
                .status(Statut.valueOf(request.getStatus()))
                .details(request.getDetails())
                .articles(request.getArticles().stream()
                        .map(articleId -> articleRepository.findById(articleId).orElse(null))
                        .collect(Collectors.toList()))
                .build();
        System.out.println("CommandeService: createCommande: request: " + request.toString());
        // Set the properties of the commande from the request here
        Commande savedCommande = commandeRepository.save(commande);

        return Mono.just(new GetCommandeResponse(
                savedCommande.getId(),
                savedCommande.getIdClient(),
                savedCommande.getDateCommande(),
                savedCommande.getIdRestaurant(),
                savedCommande.getStatus().name(),
                savedCommande.getDetails(),
                null // Pour le moment, articles est null dans GetCommandeResponse
        ));
    }

    public Mono<GetCommandeResponse> getCommande(Integer id) {
        return Mono.justOrEmpty(commandeRepository.findById(id)
                .map(commande -> new GetCommandeResponse(
                        commande.getId(),
                        commande.getIdClient(),
                        commande.getDateCommande(),
                        commande.getIdRestaurant(),
                        commande.getStatus().name(), // Convertir le statut en chaîne de caractères
                        commande.getDetails(),
                        String.valueOf(commande.getArticles().stream()
                                .map(article -> article.getId().toString()) // Utilisez la méthode appropriée pour obtenir l'identifiant de l'article
                                .collect(Collectors.toList()))
                )));
    }
}
