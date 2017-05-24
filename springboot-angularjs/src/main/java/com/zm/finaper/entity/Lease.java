package com.zm.finaper.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wzhang on 24/05/2017.
 */
@Entity
@Table(name = "LEASES")
public class Lease extends AbstractEntity {

    private Date startDate;
    private Date endDate;
    private Date dateSigned;
    @ManyToOne
    private Person tenant;
    private double bound;
    private double monthlyRent;
    private boolean internetIncluded = true;
    private boolean billIncluded = false;
    private boolean transferPermitted = true;
    private String leaseType;  // share or rent
    private boolean valid;

    public Lease() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(Date dateSigned) {
        this.dateSigned = dateSigned;
    }

    public Person getTenant() {
        return tenant;
    }

    public void setTenant(Person tenant) {
        this.tenant = tenant;
    }

    public double getBound() {
        return bound;
    }

    public void setBound(double bound) {
        this.bound = bound;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public boolean isInternetIncluded() {
        return internetIncluded;
    }

    public void setInternetIncluded(boolean internetIncluded) {
        this.internetIncluded = internetIncluded;
    }

    public boolean isBillIncluded() {
        return billIncluded;
    }

    public void setBillIncluded(boolean billIncluded) {
        this.billIncluded = billIncluded;
    }

    public boolean isTransferPermitted() {
        return transferPermitted;
    }

    public void setTransferPermitted(boolean transferPermitted) {
        this.transferPermitted = transferPermitted;
    }

    public String getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
