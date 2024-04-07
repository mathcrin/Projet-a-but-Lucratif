package fr.uphf.PABLRestaurant.service;

import fr.uphf.PABLRestaurant.DTO.CreateRestaurantRequest;
import fr.uphf.PABLRestaurant.DTO.CreateRestaurantResponse;
import fr.uphf.PABLRestaurant.entity.RestaurantEntity;
import fr.uphf.PABLRestaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Mono<CreateRestaurantResponse> createRestaurant(CreateRestaurantRequest request) {
        RestaurantEntity restaurant = new RestaurantEntity();
        restaurant.setDescription(request.getNom());
        restaurant.setAdresse(request.getAddresse());
        restaurant.setTelephone(request.getTelephone());
        restaurant.setMail(request.getMail()); // Ajout du champ mail
        RestaurantEntity savedRestaurant = restaurantRepository.save(restaurant);
        return Mono.just(new CreateRestaurantResponse(savedRestaurant.getId(), savedRestaurant.getDescription(), savedRestaurant.getAdresse(), savedRestaurant.getTelephone(), savedRestaurant.getMail()));
    }

    public Mono<CreateRestaurantResponse> getRestaurant(Integer id) {
        return Mono.justOrEmpty(restaurantRepository.findById(id))
                .map(restaurant -> new CreateRestaurantResponse(restaurant.getId(), restaurant.getDescription(), restaurant.getAdresse(), restaurant.getTelephone(), restaurant.getMail()));
    }
}