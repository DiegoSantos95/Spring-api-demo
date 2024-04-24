package com.example.demo.services.implemetations;

import com.example.demo.models.Person;
import com.example.demo.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonServiceImpl implements PersonService {
    private final HashMap<Integer, Person> map = new HashMap<Integer, Person>();
    private static final AtomicInteger counter = new AtomicInteger();

    @Override
    public Person create(Person person) {
        person.setId(counter.incrementAndGet());
        map.put(person.getId(), person);
        return person;
    }

    @Override
    public Person findById(int personID) {
        return map.get(personID);
    }
}
