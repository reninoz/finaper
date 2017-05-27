package com.zm.finaper.controller;

import com.zm.finaper.dto.LeaseDTO;
import com.zm.finaper.entity.Lease;
import com.zm.finaper.entity.Property;
import com.zm.finaper.service.LeaseService;
import com.zm.finaper.service.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wzhang on 16/05/2017.
 */
@Controller
@RequestMapping("/lease")
public class LeaseController {
    private static final Logger logger = LoggerFactory.getLogger(LeaseController.class);

    @Autowired
    LeaseService leaseService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Lease> getAllProperties() {
        return leaseService.getAllLeases();
    }

    @RequestMapping(value = "/{leaseId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LeaseDTO getLeaseAndRelatedInfo(@PathVariable Long leaseId) {
        logger.debug("Retriving lease and related info for lease {}", leaseId);
        return leaseService.findLeaseAndRelatedInfo(leaseId);
    }
}
