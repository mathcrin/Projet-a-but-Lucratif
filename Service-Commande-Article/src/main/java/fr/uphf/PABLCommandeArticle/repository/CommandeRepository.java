package fr.uphf.PABLCommandeArticle.repository;

import fr.uphf.PABLCommandeArticle.entity.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<CommandeEntity, Integer> {
}