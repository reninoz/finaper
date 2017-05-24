package com.zm.finaper.controller;

import com.zm.finaper.entity.Property;
import com.zm.finaper.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

/**
 * Created by wzhang on 16/05/2017.
 */
@Controller
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }


}
