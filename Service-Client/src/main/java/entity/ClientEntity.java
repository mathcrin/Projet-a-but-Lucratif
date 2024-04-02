package entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String addresse;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String telephone;
}
