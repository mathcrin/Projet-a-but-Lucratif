package controller;

import DTO.CreateClientRequest;
import entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import service.ClientService;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webClient;

    @PostMapping("/service")
    public ResponseEntity<ClientEntity> createClient(@RequestBody CreateClientRequest request) throws Exception {
        URI uri = discoveryClient.getInstances("clients")
                .stream().findFirst().map(ServiceInstance::getUri)
                .orElseThrow(() -> new Exception("Service not found"));

        ClientEntity response = webClient.baseUrl(uri.toString()).build().post()
                .uri("/service")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), CreateClientRequest.class)
                .retrieve()
                .bodyToMono(ClientEntity.class)
                .block();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public String getClients() throws Exception {
        URI uri = discoveryClient.getInstances("service-client")
                .stream().findFirst().map(ServiceInstance::getUri)
                .orElseThrow(() -> new Exception("Service not found"));

        String resultat = webClient.baseUrl(uri.toString()).build().get()
                .uri("/clients")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return resultat;
    }
}