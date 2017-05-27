package com.zm.finaper.dto;

import com.zm.finaper.entity.Lease;
import com.zm.finaper.entity.Rental;

/**
 * Created by wzhang on 27/05/2017.
 */
public class LeaseDTO {
    private Lease lease;
    private Iterable<Rental> rentals;

    public LeaseDTO() {
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public Iterable<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Iterable<Rental> rentals) {
        this.rentals = rentals;
    }
}
