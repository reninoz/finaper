package com.zm.finaper.service;

import com.zm.finaper.dao.LeaseRepository;
import com.zm.finaper.dao.RentalRepository;
import com.zm.finaper.dto.LeaseDTO;
import com.zm.finaper.entity.Lease;
import com.zm.finaper.entity.Rental;
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

    @Autowired
    private RentalRepository rentalRepository;

    public Iterable<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }

    public LeaseDTO findLeaseAndRelatedInfo(Long leaseId) {
        LeaseDTO dto = new LeaseDTO();
        Lease lease = leaseRepository.findOne(leaseId);
        Iterable<Rental> rentals = rentalRepository.findByLeaseId(leaseId);
        dto.setLease(lease);
        dto.setRentals(rentals);
        return dto;
    }
}

