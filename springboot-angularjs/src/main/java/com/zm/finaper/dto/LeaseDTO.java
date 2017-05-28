package com.zm.finaper.dto;

import com.zm.finaper.entity.Lease;
import com.zm.finaper.entity.Lookup;
import com.zm.finaper.entity.Rental;

/**
 * Created by wzhang on 27/05/2017.
 */
public class LeaseDTO {
    private Lease lease;
    private Iterable<Rental> rentals;
    private double totalAmountOfCash;
    private double totalAmountOfBankTransfer;

    //for new payment
    private Rental newRental = new Rental();
    
    private Iterable<Lookup> paymentTypes;

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

    public double getTotalAmountOfCash() {
        for (Rental rental :  rentals) {
            if ("cash".equals(rental.getPaymentType().getCode())) {
                totalAmountOfCash = totalAmountOfCash + rental.getAmount();
            }
        }
        return totalAmountOfCash;
    }

    public double getTotalAmountOfBankTransfer() {
        for (Rental rental :  rentals) {
            if (!"cash".equals(rental.getPaymentType().getCode())) {
                totalAmountOfBankTransfer = totalAmountOfBankTransfer + rental.getAmount();
            }
        }
        return totalAmountOfBankTransfer;
    }

    public Rental getNewRental() {
        return newRental;
    }

    public void setNewRental(Rental newRental) {
        this.newRental = newRental;
    }

	public Iterable<Lookup> getPaymentTypes() {
		return paymentTypes;
	}

	public void setPaymentTypes(Iterable<Lookup> paymentTypes) {
		this.paymentTypes = paymentTypes;
	}
    
    
}
