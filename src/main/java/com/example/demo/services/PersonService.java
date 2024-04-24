package com.example.demo.services;

import com.example.demo.models.Person;

public interface PersonService {
    Person create(final Person person);
    Person findById(final int personID);
}
