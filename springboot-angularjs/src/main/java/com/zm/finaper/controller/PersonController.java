package com.zm.finaper.controller;

import com.zm.finaper.entity.Person;
import com.zm.finaper.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wzhang on 16/05/2017.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Person> getAll() {
        return personService.getAllPersons();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person addNewPerson(@RequestBody Person person) {
        if (person == null) {
            person = new Person();
            person.setFirstName("Muran");
            person.setLastName("Liu");
        }
        return personService.addNewPerson(person);
    }
}
