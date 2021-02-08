package com.techelevator.tender;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tender {

	private static double accountBalance = 0;
	private static double totalMoneyAdded;
	
	public Tender() {};

	public double currentAccountBalance() {
		return accountBalance;
	}
	
	public void addMoney(int amountToAdd) {
		
		if ((accountBalance < 5000) && (amountToAdd > 0)) {
			if (!(accountBalance + amountToAdd > 5000)) {
				accountBalance += amountToAdd;
				totalMoneyAdded += amountToAdd;
			}
		}
	}
	
	
	public boolean checkingSufficientFunds(double costOfItem, int numberOfItems) {
		boolean sufficientFunds = false;
		double totalCost = costOfItem*numberOfItems;
		
		if (accountBalance >= totalCost) {
			sufficientFunds = true;
		}
		
		return sufficientFunds;
	}
	
	public String insufficientFundsMessage() {
		return "***Insufficient Funds - please add money to account***";
	}
	
	
	public void updateBalance(double costOfItem, int numberOfItems) {
		
		double totalCost = costOfItem*numberOfItems;
		
		if (totalCost <= accountBalance) {
			accountBalance -= totalCost;
		}
		
	}
	
	public double getBill() {
		double bill = totalMoneyAdded - accountBalance;
		return round(bill, 2);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	

	public void resetAccountBalance() {
		accountBalance = 0;
	}
	
}
