package service;

import DTO.CreateEmployeRequest;
import entity.PersonnelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmployerRepository;

import java.util.List;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public PersonnelEntity createEmployer(CreateEmployeRequest request) {
        PersonnelEntity employer = new PersonnelEntity();
        // Set the properties of the employer based on the request
        // employer.set...
        return employerRepository.save(employer);
    }

    public List<PersonnelEntity> getAllEmployers() {
        return employerRepository.findAll();
    }
}