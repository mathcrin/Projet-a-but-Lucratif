package fr.uphf.PABLRestaurant.repository;

import fr.uphf.PABLRestaurant.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {
}