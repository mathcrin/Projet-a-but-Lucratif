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
@Table(name = "restaurant")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String telephone;


}
