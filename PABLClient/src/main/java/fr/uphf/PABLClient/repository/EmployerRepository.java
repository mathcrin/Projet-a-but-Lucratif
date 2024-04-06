package fr.uphf.PABLClient.repository;


import fr.uphf.PABLClient.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Personnel, String> {
}