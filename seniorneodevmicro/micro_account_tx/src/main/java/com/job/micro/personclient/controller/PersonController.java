package com.job.micro.personclient.controller;

import com.job.micro.personclient.entity.Person;
import com.job.micro.personclient.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/persons")
@Transactional
public class PersonController {

    private PersonService personService;

    // build create person REST API
    // http://localhost:8080/api/person/
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person savedPerson = personService.createPerson(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    // build get person by id REST API
    // http://localhost:8080/api/person/1
    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long personId){
        Person person = personService.getPersonById(personId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // build update person REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/person/1
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long personId,
                                           @RequestBody Person person){
        person.setId(personId);
        Person updatedPerson = personService.updatePerson(person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    // build delete person REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Long personId){
        personService.deletePerson(personId);
        return new ResponseEntity<>("Person successfully deleted!", HttpStatus.OK);
    }

}
