package com.zm.finaper.dto;


import com.zm.finaper.entity.Bill;
import com.zm.finaper.entity.BillItem;
import com.zm.finaper.entity.Lease;

import java.util.Date;
import java.util.List;

/**
 * Created by wzhang on 18/05/2017.
 */
public class CalculateDTO {

//    private String payFor;
    private Long leaseId;
    private Lease lease;
    private String payer;
    private Date waterSupplyStartDate;
    private Date waterSupplyEndDate;
    private double waterSupplyAmount;

    private Date waterConsumStartDate;
    private Date waterConsumEndDate;
    private double waterConsumAmount;
    private Date electricalSupplyStartDate;
    private Date electricalSupplyEndDate;
    private double electricalSupplyAmount;

    private Date electricalConsumStartDate;
    private Date electricalConsumEndDate;
    private double electricalConsumAmount;
    private Date gasSupplyStartDate;
    private Date gasSupplyEndDate;
    private double gasSupplyAmount;

    private Date gasConsumStartDate;
    private Date gasConsumEndDate;
    private double gasConsumAmount;
    
    private Date consumStartDateAbsent;
    private Date consumEndDateAbsent;
    
    private Date supplyStartDateAbsent;
    private Date supplyEndDateAbsent;

    private int numberOfPersonShareForWater;
    private int numberOfPersonShareForElectrical;
    private int numberOfPersonShareForGas;

    private int numOfDaysToPayForWaterSupply;
    private int numOfDaysToPayForWaterConsum;

    private int numOfDaysToPayForElectricalSupply;
    private int numOfDaysToPayForElectricalConsum;

    private int numOfDaysToPayForGasSupply;
    private int numOfDaysToPayForGasConsum;

    private double waterSupplyPerPerson;
    private double waterConsumPerPerson;

    private double electricalSupplyPerPerson;
    private double electricalConsumPerPerson;

    private double gasSupplyPerPerson;
    private double gasConsumPerPerson;

    private double totalPerPerson;

    private Bill bill = new Bill();

//    private List<BillItem> billItems;

    public CalculateDTO() {
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public String getPayer() {
        return payer;
    }

    public Long getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(Long leaseId) {
        this.leaseId = leaseId;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

/*    public String getPayFor() {
        return payFor;
    }

    public void setPayFor(String payFor) {
        this.payFor = payFor;
    }*/

    public Date getWaterSupplyStartDate() {
        return waterSupplyStartDate;
    }

    public void setWaterSupplyStartDate(Date waterSupplyStartDate) {
        this.waterSupplyStartDate = waterSupplyStartDate;
    }

    public Date getWaterSupplyEndDate() {
        return waterSupplyEndDate;
    }

    public void setWaterSupplyEndDate(Date waterSupplyEndDate) {
        this.waterSupplyEndDate = waterSupplyEndDate;
    }

    public double getWaterSupplyAmount() {
        return waterSupplyAmount;
    }

    public void setWaterSupplyAmount(double waterSupplyAmount) {
        this.waterSupplyAmount = waterSupplyAmount;
    }

    public Date getWaterConsumStartDate() {
        return waterConsumStartDate;
    }

    public void setWaterConsumStartDate(Date waterConsumStartDate) {
        this.waterConsumStartDate = waterConsumStartDate;
    }

    public Date getWaterConsumEndDate() {
        return waterConsumEndDate;
    }

    public void setWaterConsumEndDate(Date waterConsumEndDate) {
        this.waterConsumEndDate = waterConsumEndDate;
    }

    public double getWaterConsumAmount() {
        return waterConsumAmount;
    }

    public void setWaterConsumAmount(double waterConsumAmount) {
        this.waterConsumAmount = waterConsumAmount;
    }

    public Date getElectricalSupplyStartDate() {
        return electricalSupplyStartDate;
    }

    public void setElectricalSupplyStartDate(Date electricalSupplyStartDate) {
        this.electricalSupplyStartDate = electricalSupplyStartDate;
    }

    public Date getElectricalSupplyEndDate() {
        return electricalSupplyEndDate;
    }

    public void setElectricalSupplyEndDate(Date electricalSupplyEndDate) {
        this.electricalSupplyEndDate = electricalSupplyEndDate;
    }

    public double getElectricalSupplyAmount() {
        return electricalSupplyAmount;
    }

    public void setElectricalSupplyAmount(double electricalSupplyAmount) {
        this.electricalSupplyAmount = electricalSupplyAmount;
    }

    public Date getElectricalConsumStartDate() {
        return electricalConsumStartDate;
    }

    public void setElectricalConsumStartDate(Date electricalConsumStartDate) {
        this.electricalConsumStartDate = electricalConsumStartDate;
    }

    public Date getElectricalConsumEndDate() {
        return electricalConsumEndDate;
    }

    public void setElectricalConsumEndDate(Date electricalConsumEndDate) {
        this.electricalConsumEndDate = electricalConsumEndDate;
    }

    public double getElectricalConsumAmount() {
        return electricalConsumAmount;
    }

    public void setElectricalConsumAmount(double electricalConsumAmount) {
        this.electricalConsumAmount = electricalConsumAmount;
    }

    public Date getGasSupplyStartDate() {
        return gasSupplyStartDate;
    }

    public void setGasSupplyStartDate(Date gasSupplyStartDate) {
        this.gasSupplyStartDate = gasSupplyStartDate;
    }

    public Date getGasSupplyEndDate() {
        return gasSupplyEndDate;
    }

    public void setGasSupplyEndDate(Date gasSupplyEndDate) {
        this.gasSupplyEndDate = gasSupplyEndDate;
    }

    public double getGasSupplyAmount() {
        return gasSupplyAmount;
    }

    public void setGasSupplyAmount(double gasSupplyAmount) {
        this.gasSupplyAmount = gasSupplyAmount;
    }

    public Date getGasConsumStartDate() {
        return gasConsumStartDate;
    }

    public void setGasConsumStartDate(Date gasConsumStartDate) {
        this.gasConsumStartDate = gasConsumStartDate;
    }

    public Date getGasConsumEndDate() {
        return gasConsumEndDate;
    }

    public void setGasConsumEndDate(Date gasConsumEndDate) {
        this.gasConsumEndDate = gasConsumEndDate;
    }

    public double getGasConsumAmount() {
        return gasConsumAmount;
    }

    public void setGasConsumAmount(double gasConsumAmount) {
        this.gasConsumAmount = gasConsumAmount;
    }

    public int getNumberOfPersonShareForWater() {
        return numberOfPersonShareForWater;
    }

    public void setNumberOfPersonShareForWater(int numberOfPersonShareForWater) {
        this.numberOfPersonShareForWater = numberOfPersonShareForWater;
    }

    public int getNumberOfPersonShareForElectrical() {
        return numberOfPersonShareForElectrical;
    }

    public void setNumberOfPersonShareForElectrical(int numberOfPersonShareForElectrical) {
        this.numberOfPersonShareForElectrical = numberOfPersonShareForElectrical;
    }

    public int getNumberOfPersonShareForGas() {
        return numberOfPersonShareForGas;
    }

    public void setNumberOfPersonShareForGas(int numberOfPersonShareForGas) {
        this.numberOfPersonShareForGas = numberOfPersonShareForGas;
    }

    public int getNumOfDaysToPayForWaterSupply() {
        return numOfDaysToPayForWaterSupply;
    }

    public void setNumOfDaysToPayForWaterSupply(int numOfDaysToPayForWaterSupply) {
        this.numOfDaysToPayForWaterSupply = numOfDaysToPayForWaterSupply;
    }

    public int getNumOfDaysToPayForWaterConsum() {
        return numOfDaysToPayForWaterConsum;
    }

    public void setNumOfDaysToPayForWaterConsum(int numOfDaysToPayForWaterConsum) {
        this.numOfDaysToPayForWaterConsum = numOfDaysToPayForWaterConsum;
    }

    public int getNumOfDaysToPayForElectricalSupply() {
        return numOfDaysToPayForElectricalSupply;
    }

    public void setNumOfDaysToPayForElectricalSupply(int numOfDaysToPayForElectricalSupply) {
        this.numOfDaysToPayForElectricalSupply = numOfDaysToPayForElectricalSupply;
    }

    public int getNumOfDaysToPayForElectricalConsum() {
        return numOfDaysToPayForElectricalConsum;
    }

    public void setNumOfDaysToPayForElectricalConsum(int numOfDaysToPayForElectricalConsum) {
        this.numOfDaysToPayForElectricalConsum = numOfDaysToPayForElectricalConsum;
    }

    public int getNumOfDaysToPayForGasSupply() {
        return numOfDaysToPayForGasSupply;
    }

    public void setNumOfDaysToPayForGasSupply(int numOfDaysToPayForGasSupply) {
        this.numOfDaysToPayForGasSupply = numOfDaysToPayForGasSupply;
    }

    public int getNumOfDaysToPayForGasConsum() {
        return numOfDaysToPayForGasConsum;
    }

    public void setNumOfDaysToPayForGasConsum(int numOfDaysToPayForGasConsum) {
        this.numOfDaysToPayForGasConsum = numOfDaysToPayForGasConsum;
    }

    public double getWaterSupplyPerPerson() {
        return waterSupplyPerPerson;
    }

    public void setWaterSupplyPerPerson(double waterSupplyPerPerson) {
        this.waterSupplyPerPerson = waterSupplyPerPerson;
    }

    public double getWaterConsumPerPerson() {
        return waterConsumPerPerson;
    }

    public void setWaterConsumPerPerson(double waterConsumPerPerson) {
        this.waterConsumPerPerson = waterConsumPerPerson;
    }

    public double getElectricalSupplyPerPerson() {
        return electricalSupplyPerPerson;
    }

    public void setElectricalSupplyPerPerson(double electricalSupplyPerPerson) {
        this.electricalSupplyPerPerson = electricalSupplyPerPerson;
    }

    public double getElectricalConsumPerPerson() {
        return electricalConsumPerPerson;
    }

    public void setElectricalConsumPerPerson(double electricalConsumPerPerson) {
        this.electricalConsumPerPerson = electricalConsumPerPerson;
    }

    public double getGasSupplyPerPerson() {
        return gasSupplyPerPerson;
    }

    public void setGasSupplyPerPerson(double gasSupplyPerPerson) {
        this.gasSupplyPerPerson = gasSupplyPerPerson;
    }

    public double getGasConsumPerPerson() {
        return gasConsumPerPerson;
    }

    public void setGasConsumPerPerson(double gasConsumPerPerson) {
        this.gasConsumPerPerson = gasConsumPerPerson;
    }

    public double getTotalPerPerson() {
        return totalPerPerson;
    }

    public void setTotalPerPerson(double totalPerPerson) {
        this.totalPerPerson = totalPerPerson;
    }

/*    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }*/

	public Date getConsumStartDateAbsent() {
		return consumStartDateAbsent;
	}

	public void setConsumStartDateAbsent(Date consumStartDateAbsent) {
		this.consumStartDateAbsent = consumStartDateAbsent;
	}

	public Date getConsumEndDateAbsent() {
		return consumEndDateAbsent;
	}

	public void setConsumEndDateAbsent(Date consumEndDateAbsent) {
		this.consumEndDateAbsent = consumEndDateAbsent;
	}

	public Date getSupplyStartDateAbsent() {
		return supplyStartDateAbsent;
	}

	public void setSupplyStartDateAbsent(Date supplyStartDateAbsent) {
		this.supplyStartDateAbsent = supplyStartDateAbsent;
	}

	public Date getSupplyEndDateAbsent() {
		return supplyEndDateAbsent;
	}

	public void setSupplyEndDateAbsent(Date supplyEndDateAbsent) {
		this.supplyEndDateAbsent = supplyEndDateAbsent;
	}


}
