package service;

import DTO.CreateClientRequest;
import entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Mono<ClientEntity> createClient(CreateClientRequest request) {
        ClientEntity client = new ClientEntity();
        client.setNom(request.getNom());
        client.setPrenom(request.getPrenom());
        client.setAddresse(request.getAddresse());
        client.setMail(request.getMail());
        client.setTelephone(request.getTelephone());
        return Mono.just(clientRepository.save(client));
    }

    public Mono<String> getClients() {
        List<ClientEntity> clients = clientRepository.findAll();
        return Mono.just(clients.toString());
    }
}