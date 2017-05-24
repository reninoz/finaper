package com.zm.finaper.service;

import com.zm.finaper.dao.LeaseRepository;
import com.zm.finaper.entity.Lease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Created by wzhang on 24/05/2017.
 */
@Service
public class LeaseService {

    @Autowired
    private LeaseRepository leaseRepository;

    public Iterable<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }
}

