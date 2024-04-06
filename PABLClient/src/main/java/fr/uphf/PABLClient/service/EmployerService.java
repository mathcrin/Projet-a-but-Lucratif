package fr.uphf.PABLClient.service;


import fr.uphf.PABLClient.DTO.CreateEmployeRequest;
import fr.uphf.PABLClient.entity.Personnel;
import fr.uphf.PABLClient.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public Personnel createEmployer(CreateEmployeRequest request) {
        Personnel employer = new Personnel();
        // Set the properties of the employer based on the request
        // employer.set...
        return employerRepository.save(employer);
    }

    public List<Personnel> getAllEmployers() {
        return employerRepository.findAll();
    }
}