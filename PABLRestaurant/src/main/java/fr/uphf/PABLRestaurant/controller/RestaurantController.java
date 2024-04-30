package fr.uphf.PABLRestaurant.controller;


import fr.uphf.PABLRestaurant.DTO.CreateRestaurantRequest;
import fr.uphf.PABLRestaurant.DTO.CreateRestaurantResponse;
import fr.uphf.PABLRestaurant.entity.RestaurantEntity;
import fr.uphf.PABLRestaurant.repository.RestaurantRepository;
import fr.uphf.PABLRestaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<CreateRestaurantResponse> createRestaurant(@RequestBody CreateRestaurantRequest request) {
        return restaurantService.createRestaurant(request)
                .map(response -> new ResponseEntity<>(response, HttpStatus.CREATED))
                .block();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateRestaurantResponse> getRestaurant(@PathVariable Integer id) {
        return restaurantService.getRestaurant(id)
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND))
                .block();
    }
}