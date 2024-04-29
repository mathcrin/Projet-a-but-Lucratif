package fr.uphf.PABLCommandeArticle.service;

import fr.uphf.PABLCommandeArticle.dto.PostCommandeRequest;
import fr.uphf.PABLCommandeArticle.dto.GetCommandeResponse;
import fr.uphf.PABLCommandeArticle.entity.Commande;
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
        Commande commande = new Commande();
        // Set the properties of the commande from the request here
        Commande savedCommande = commandeRepository.save(commande);
        return Mono.just(new GetCommandeResponse(
                savedCommande.getId(),
                savedCommande.getClientId(),
                savedCommande.getDateCommande(),
                savedCommande.getRestaurantId(),
                savedCommande.getStatus().name(),
                savedCommande.getDetails(),
                null // Pour le moment, articles est null dans GetCommandeResponse
        ));
    }

    public Mono<GetCommandeResponse> getCommande(Integer id) {
        return Mono.justOrEmpty(commandeRepository.findById(id)
                .map(commande -> new GetCommandeResponse(
                        commande.getId(),
                        commande.getClientId(),
                        commande.getDateCommande(),
                        commande.getRestaurantId(),
                        commande.getStatus().name(), // Convertir le statut en chaîne de caractères
                        commande.getDetails(),
                        String.valueOf(commande.getArticles().stream()
                                .map(article -> article.getId().toString()) // Utilisez la méthode appropriée pour obtenir l'identifiant de l'article
                                .collect(Collectors.toList()))
                )));
    }
}
