package fr.uphf.PABLCommandeArticle.repository;

import fr.uphf.PABLCommandeArticle.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}