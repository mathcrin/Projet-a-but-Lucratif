// CommandeController.java
package fr.uphf.PABLCommandeArticle.controller;

import fr.uphf.PABLCommandeArticle.dto.PostCommandeRequest;
import fr.uphf.PABLCommandeArticle.dto.GetCommandeResponse;
import fr.uphf.PABLCommandeArticle.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @PostMapping("/create")
    public Mono<ResponseEntity<GetCommandeResponse>> createCommande(@RequestBody PostCommandeRequest request) {
        return commandeService.createCommande(request)
                .map(response -> new ResponseEntity<>(response, HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<GetCommandeResponse>> getCommande(@PathVariable Integer id) {
        return commandeService.getCommande(id)
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}