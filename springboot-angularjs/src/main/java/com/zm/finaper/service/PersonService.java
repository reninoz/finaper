package com.zm.finaper.service;

import com.zm.finaper.dao.PersonRepository;
import com.zm.finaper.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzhang on 19/05/2017.
 */

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
//        return getSampleData();
    }

    public Person addNewPerson(Person person) {
        return personRepository.save(person);
    }

    private List<Person> getSampleData() {
        List<Person> data = new ArrayList();

        return data;
    }

}
