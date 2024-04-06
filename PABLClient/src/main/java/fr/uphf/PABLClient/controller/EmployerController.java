package fr.uphf.PABLClient.controller;

import fr.uphf.PABLClient.DTO.CreateEmployeRequest;
import fr.uphf.PABLClient.entity.Personnel;
import fr.uphf.PABLClient.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping
    public ResponseEntity<Personnel> createEmployer(@RequestBody CreateEmployeRequest request) {
        Personnel employer = employerService.createEmployer(request);
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