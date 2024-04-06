package fr.uphf.PABLClient.controller;


import fr.uphf.PABLClient.DTO.CreateClientRequest;
import fr.uphf.PABLClient.entity.Client;
import fr.uphf.PABLClient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webClient;

    @PostMapping("/service")
    public ResponseEntity<Client> createClient(@RequestBody CreateClientRequest request) throws Exception {
        URI uri = discoveryClient.getInstances("clients")
                .stream().findFirst().map(ServiceInstance::getUri)
                .orElseThrow(() -> new Exception("Service not found"));

        Client response = webClient.baseUrl(uri.toString()).build().post()
                .uri("/service")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), CreateClientRequest.class)
                .retrieve()
                .bodyToMono(Client.class)
                .block();
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<String> getClients() throws Exception {
//        URI uri = discoveryClient.getInstances("service-client")
//                .stream().findFirst().map(ServiceInstance::getUri)
//                .orElseThrow(() -> new Exception("Service not found"));
//
//        String resultat = webClient.baseUrl(uri.toString()).build().get()
//                .uri("/clients")
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//        return resultat;
        return ResponseEntity.ok("GET Client fonctionnel");
    }
}
