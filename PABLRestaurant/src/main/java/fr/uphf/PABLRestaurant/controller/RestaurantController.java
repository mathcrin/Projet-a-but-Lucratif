package fr.uphf.PABLRestaurant.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @GetMapping()
    public ResponseEntity<String> getRestaurants() throws Exception {
        return ResponseEntity.ok("GET Restaurant fonctionnel");
    }
}
