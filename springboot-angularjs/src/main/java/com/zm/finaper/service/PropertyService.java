package com.zm.finaper.service;

import com.zm.finaper.dao.PropertyRepository;
import com.zm.finaper.entity.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wzhang on 16/05/2017.
 */
@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Iterable<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

}
