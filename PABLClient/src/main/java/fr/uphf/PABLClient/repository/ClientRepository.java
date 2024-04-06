package fr.uphf.PABLClient.repository;

import fr.uphf.PABLClient.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
