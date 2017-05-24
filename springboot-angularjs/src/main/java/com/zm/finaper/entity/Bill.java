package com.zm.finaper.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wzhang on 24/05/2017.
 */
@Entity
@Table(name = "BILLS")
public class Bill extends AbstractEntity {

    private String title;
    @ManyToOne
    private Person payer;
    @ManyToOne
    private Property property;
    private double amount;
    @OneToMany
    @JoinColumn(name = "BILL_ID")
    private List<BillItem> billItems;
    private Date dateIssued;

    public Bill() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPayer() {
        return payer;
    }

    public void setPayer(Person payer) {
        this.payer = payer;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }
}
