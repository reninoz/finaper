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
//        return getSampleData();
    }

    private List<Property> getSampleData() {
        List<Property> data = new ArrayList();
        data.add(new Property( "house", "Dickson", "Dickson Address", "Five bedrooms, one toilet", 5));
        data.add(new Property( "granny flat", "DicksonA", "DicksonA Address", "One bedroom, one toilet", 1));
        data.add(new Property( "house", "Cowper1", "Cowper1 Address", "Five bedrooms, one toilet", 5));
        data.add(new Property( "house", "Cowper2", "Cowper2 Address", "Five bedrooms, two toilet", 5));
        return data;
    }

}
