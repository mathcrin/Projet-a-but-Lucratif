package controller;

import DTO.CreateEmployeRequest;
import entity.PersonnelEntity;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping
    public ResponseEntity<PersonnelEntity> createEmployer(@RequestBody CreateEmployeRequest request) {
        PersonnelEntity employer = employerService.createEmployer(request);
        return ResponseEntity.ok(employer);
    }

    /*@GetMapping
    public ResponseEntity<List<PersonnelEntity>> getAllEmployers() {
        List<PersonnelEntity> employers = employerService.getAllEmployers();
        return ResponseEntity.ok(employers);
        @GetMapping("/employers")
        public String getEmployersFromOtherService() throws Exception {
            URI uri = discoveryClient.getInstances("service-employer")
                    .stream().findFirst().map(serviceInstance -> serviceInstance.getUri())
                    .orElseThrow(() -> new Exception("Service not found"));

            WebClient client = WebClient.create(uri.toString());
            String resultat = client.get()
                    .uri("/employers")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            return resultat;
        }
    }*/
}