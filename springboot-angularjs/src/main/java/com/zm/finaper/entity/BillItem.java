package com.zm.finaper.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wzhang on 19/05/2017.
 */
@Entity
@Table(name = "BILL_ITEMS")
public class BillItem  extends AbstractEntity {

    private String title;
    private double totalAmount;
    private Date startDate;
    private Date endDate;
    private Date startDateAbsent;
    private Date endDateAbsent;
    private int numOfDays;
    private int numOfDaysAbsent;
    private int numOfDaysToPay;
    private int numOfPerson;
    private double dailyAmount;
    private double dailyAmountPerPerson;
    private double itemAmount;

    public BillItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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

    public Date getStartDateAbsent() {
        return startDateAbsent;
    }

    public void setStartDateAbsent(Date startDateAbsent) {
        this.startDateAbsent = startDateAbsent;
    }

    public Date getEndDateAbsent() {
        return endDateAbsent;
    }

    public void setEndDateAbsent(Date endDateAbsent) {
        this.endDateAbsent = endDateAbsent;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public int getNumOfDaysAbsent() {
        return numOfDaysAbsent;
    }

    public void setNumOfDaysAbsent(int numOfDaysAbsent) {
        this.numOfDaysAbsent = numOfDaysAbsent;
    }

    public int getNumOfDaysToPay() {
        return numOfDaysToPay;
    }

    public void setNumOfDaysToPay(int numOfDaysToPay) {
        this.numOfDaysToPay = numOfDaysToPay;
    }

    public int getNumOfPerson() {
        return numOfPerson;
    }

    public void setNumOfPerson(int numOfPerson) {
        this.numOfPerson = numOfPerson;
    }

    public double getDailyAmount() {
        return dailyAmount;
    }

    public void setDailyAmount(double dailyAmount) {
        this.dailyAmount = dailyAmount;
    }

    public double getDailyAmountPerPerson() {
        return dailyAmountPerPerson;
    }

    public void setDailyAmountPerPerson(double dailyAmountPerPerson) {
        this.dailyAmountPerPerson = dailyAmountPerPerson;
    }

    public double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }
}
