package com.zm.finaper.dao;

import com.zm.finaper.entity.Property;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wzhang on 24/05/2017.
 */
public interface PropertyRepository extends CrudRepository<Property, Long> {
}
