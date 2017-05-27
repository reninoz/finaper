package com.zm.finaper.dao;

import com.zm.finaper.entity.Rental;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by wzhang on 27/05/2017.
 */
public interface RentalRepository  extends CrudRepository<Rental, Long> {
    List<Rental> findByLeaseId(Long leaseId);
}
