package com.zm.finaper.service;

import com.zm.finaper.dto.CalculateDTO;
import com.zm.finaper.entity.BillItem;
import com.zm.finaper.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzhang on 19/05/2017.
 */
@Service
public class CalculateService {

	public List<BillItem> calculateBill(CalculateDTO dto) {
		List<BillItem> results = new ArrayList();
		results.add(calculateElecSupply(dto));
		results.add(calculateElecConsum(dto));

		results.add(calculateWaterSupply(dto));
		results.add(calculateWaterConsum(dto));

		results.add(calculateGasSupply(dto));
		results.add(calculateGasConsum(dto));

		return results;
	}

	private BillItem calculateElecSupply(CalculateDTO dto) {

		BillItem item = new BillItem();

		item.setTitle("Electricity Supply");
		item.setTotalAmount(dto.getElectricalSupplyAmount());
		item.setStartDate(dto.getElectricalSupplyStartDate());
		item.setEndDate(dto.getElectricalSupplyEndDate());
		item.setStartDateAbsent(dto.getSupplyStartDateAbsent());
		item.setEndDateAbsent(dto.getSupplyEndDateAbsent());
		item.setNumOfPerson(dto.getNumberOfPersonShareForElectrical());

		int numOfDays = DateUtil.daysBetweenInclusive(item.getStartDate(),
				item.getEndDate());
		item.setNumOfDays(numOfDays);
		

		double dailyAmount = item.getTotalAmount() / numOfDays;
		item.setDailyAmount(dailyAmount);

		double dailyAmountPerPerson = dailyAmount / item.getNumOfPerson();
		item.setDailyAmountPerPerson(dailyAmountPerPerson);

		// TODO move in and move out
		int numOfDaysToPay = numOfDays;
		item.setNumOfDaysToPay(numOfDaysToPay);
		
		double amountPerPerson = numOfDays * dailyAmountPerPerson;
		item.setItemAmount(amountPerPerson);

		return item;
	}

	private BillItem calculateElecConsum(CalculateDTO dto) {
		BillItem item = new BillItem();
		item.setTitle("Electricity Consumption");
		item.setTotalAmount(dto.getElectricalConsumAmount());
		item.setStartDate(dto.getElectricalConsumStartDate());
		item.setEndDate(dto.getElectricalConsumEndDate());
		item.setStartDateAbsent(dto.getConsumStartDateAbsent());
		item.setEndDateAbsent(dto.getConsumEndDateAbsent());
		item.setNumOfPerson(dto.getNumberOfPersonShareForElectrical());
		// TODO
		return item;
	}

	private BillItem calculateWaterSupply(CalculateDTO dto) {

		BillItem item = new BillItem();
		item.setTitle("Water Supply");
		item.setTotalAmount(dto.getWaterSupplyAmount());
		item.setStartDate(dto.getWaterSupplyStartDate());
		item.setEndDate(dto.getWaterSupplyEndDate());
		item.setStartDateAbsent(dto.getSupplyStartDateAbsent());
		item.setEndDateAbsent(dto.getSupplyEndDateAbsent());
		item.setNumOfPerson(dto.getNumberOfPersonShareForWater());
		// TODO
		return item;
	}

	private BillItem calculateWaterConsum(CalculateDTO dto) {

		BillItem item = new BillItem();
		item.setTitle("Water Consumption");
		item.setTotalAmount(dto.getWaterConsumAmount());
		item.setStartDate(dto.getWaterConsumStartDate());
		item.setEndDate(dto.getWaterConsumEndDate());
		item.setStartDateAbsent(dto.getConsumStartDateAbsent());
		item.setEndDateAbsent(dto.getConsumEndDateAbsent());
		item.setNumOfPerson(dto.getNumberOfPersonShareForWater());
		// TODO
		return item;
	}

	private BillItem calculateGasSupply(CalculateDTO dto) {

		BillItem item = new BillItem();
		item.setTitle("Gas Supply");
		item.setTotalAmount(dto.getGasSupplyAmount());
		item.setStartDate(dto.getGasSupplyStartDate());
		item.setEndDate(dto.getGasSupplyEndDate());
		item.setStartDateAbsent(dto.getSupplyStartDateAbsent());
		item.setEndDateAbsent(dto.getSupplyEndDateAbsent());
		item.setNumOfPerson(dto.getNumberOfPersonShareForGas());
		// TODO
		return item;
	}

	private BillItem calculateGasConsum(CalculateDTO dto) {

		BillItem item = new BillItem();
		item.setTitle("Gas Consumption");
		item.setTotalAmount(dto.getGasConsumAmount());
		item.setStartDate(dto.getGasConsumStartDate());
		item.setEndDate(dto.getGasConsumEndDate());
		item.setStartDateAbsent(dto.getConsumStartDateAbsent());
		item.setEndDateAbsent(dto.getConsumEndDateAbsent());
		item.setNumOfPerson(dto.getNumberOfPersonShareForGas());
		// TODO
		return item;
	}
}
