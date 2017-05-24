package com.zm.finaper.dao;


import com.zm.finaper.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wzhang on 23/05/2017.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}
