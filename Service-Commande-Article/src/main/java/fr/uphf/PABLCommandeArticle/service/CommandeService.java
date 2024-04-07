package fr.uphf.PABLCommandeArticle.service;

import fr.uphf.PABLCommandeArticle.dto.PostCommandeRequest;
import fr.uphf.PABLCommandeArticle.dto.GetCommandeResponse;
import fr.uphf.PABLCommandeArticle.entity.CommandeEntity;
import fr.uphf.PABLCommandeArticle.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public Mono<GetCommandeResponse> createCommande(PostCommandeRequest request) {
        CommandeEntity commande = new CommandeEntity();
        // Set the properties of the commande from the request here
        CommandeEntity savedCommande = commandeRepository.save(commande);
        return Mono.just(new GetCommandeResponse(savedCommande.getId(), savedCommande.getClientId(), savedCommande.getDateCommande(), savedCommande.getRestaurantId(), savedCommande.getStatus().toString(), savedCommande.getDetails()));
    }

    public Mono<GetCommandeResponse> getCommande(Integer id) {
        return Mono.justOrEmpty(commandeRepository.findById(id)
                .map(commande -> new GetCommandeResponse(commande.getId(), commande.getClientId(), commande.getDateCommande(), commande.getRestaurantId(), commande.getStatus().toString(), commande.getDetails())));
    }
}