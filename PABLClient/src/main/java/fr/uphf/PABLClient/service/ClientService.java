package fr.uphf.PABLClient.service;

import fr.uphf.PABLClient.DTO.CreateClientRequest;
import fr.uphf.PABLClient.DTO.CreateClientResponse;
import fr.uphf.PABLClient.entity.Client;
import fr.uphf.PABLClient.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service

public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Mono<Client> createClient(CreateClientRequest request) {
        Client client = new Client();
        client.setNom(request.getNom());
        client.setPrenom(request.getPrenom());
        client.setAddresse(request.getAddresse());
        client.setMail(request.getMail());
        client.setTelephone(request.getTelephone());
        return Mono.just(clientRepository.save(client));
    }
    public Mono<CreateClientResponse> getClient(Long id) {
        return Flux.fromStream(
                        clientRepository.findById(String.valueOf(id))
                                .map(client -> new CreateClientResponse(client.getId(), client.getNom(), client.getPrenom(), client.getAddresse(), client.getMail(), client.getTelephone()))
                                .stream())
                .next();
    }
    public Mono<String> getClients() {
        List<Client> clients = clientRepository.findAll();
        return Mono.just(clients.toString());
    }
    public Mono<Client> getClientByEmail(String email) {
        return Mono.justOrEmpty(clientRepository.findByMail(email));
    }
}
