package com.example.demo.controller;

import com.example.demo.documents.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
public class PersonController {
    private PersonRepository personRepository;
    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @GetMapping("/persons/{country}")
    public ResponseEntity<List<Person>> findPersonByCountry(@PathVariable("country") String country)
    {
        return ResponseEntity.ok(personRepository.findByCountry(country));
    }
}
