package fr.uphf.PABLClient.controller;


import fr.uphf.PABLClient.DTO.CreateClientRequest;
import fr.uphf.PABLClient.DTO.CreateClientResponse;
import fr.uphf.PABLClient.entity.Client;
import fr.uphf.PABLClient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webClient;

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody CreateClientRequest request) {
        Client newClient = clientService.createClient(request).block();
        if (newClient != null) {
            return new ResponseEntity<>(newClient, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateClientResponse> getClient(@PathVariable Long id) {
        CreateClientResponse clientResponse = clientService.getClient(id).block();
        if (clientResponse != null) {
            return new ResponseEntity<>(clientResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/existsByEmail")
    public ResponseEntity<Client> getClientByEmail(@RequestParam String email) {
        Client client = clientService.getClientByEmail(email).block();
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}