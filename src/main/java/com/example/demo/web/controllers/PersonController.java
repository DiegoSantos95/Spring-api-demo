package com.example.demo.web.controllers;

import com.example.demo.models.Person;
import com.example.demo.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@Valid @RequestBody Person person) {
        return personService.create(person);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{person_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(@PathVariable(value = "person_id") int personID){
        Optional<Person> res = Optional.ofNullable(personService.findById(personID));
        if (!res.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found");
        }
            return personService.findById(personID);
    }

}
