package com.techelevator.tender;

public class Tender {

	private static double accountBalance;
	
	public Tender() {};

	public double currentAccountBalance() {
		return accountBalance;
	}
	
	public void addMoney(int amountToAdd) {
		
		if ((accountBalance < 5000) && (amountToAdd > 0)) {
			if (!(accountBalance + amountToAdd > 5000)) {
				accountBalance += amountToAdd;
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
	
}
