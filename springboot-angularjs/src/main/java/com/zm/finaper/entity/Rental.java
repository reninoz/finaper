package com.zm.finaper.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wzhang on 24/05/2017.
 */
@Entity
@Table(name="RENTALS")
public class Rental extends AbstractEntity {

    private double amount;
    private String description;
    private String title;
    private Date dueDate;
    private Date datePaid;
    @ManyToOne
    private Lookup paymentType;

    @ManyToOne
    private Lease lease;

    public Rental() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    public Lookup getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Lookup paymentType) {
        this.paymentType = paymentType;
    }
}
