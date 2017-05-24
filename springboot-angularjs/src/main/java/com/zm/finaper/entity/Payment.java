package com.zm.finaper.entity;

import javax.persistence.ManyToOne;

/**
 * Created by wzhang on 24/05/2017.
 */
public class Payment  extends AbstractEntity {

    private double amount;
    private String description;
    private String title;
    private boolean isIncome;

    @ManyToOne
    private Property property;

    @ManyToOne
    private Lease lease;

    public Payment() {
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

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }
}
