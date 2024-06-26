package fr.uphf.PABLClient.entity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "client")
public class Client {
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
