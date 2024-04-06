package fr.uphf.PABLClient.service;

import fr.uphf.PABLClient.DTO.CreateClientRequest;
import fr.uphf.PABLClient.entity.Client;
import fr.uphf.PABLClient.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Mono<String> getClients() {
        List<Client> clients = clientRepository.findAll();
        return Mono.just(clients.toString());
    }
}