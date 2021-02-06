package com.techelevator.tender;

public class Tender {

	private double accountBalance;
	
	public Tender() {};

	public double currentAccountBalance() {
		return accountBalance;
	}
	
	public void addMoney(int amountToAdd) {
		
		if ((this.accountBalance < 5000) && (amountToAdd > 0)) {
			if (!(this.accountBalance + amountToAdd > 5000)) {
				this.accountBalance += amountToAdd;
			}
		}
	}
	
	
	public boolean checkingSufficientFunds(double costOfItem, int numberOfItems) {
		boolean sufficientFunds = false;
		double totalCost = costOfItem*numberOfItems;
		
		if (this.accountBalance >= totalCost) {
			sufficientFunds = true;
		}
		
		return sufficientFunds;
	}
	
	public String insufficientFundsMessage() {
		return "***Insufficient Funds - please add money to account***";
	}
	
	
	public void updateBalance(double costOfItem, int numberOfItems) {
		
		double totalCost = costOfItem*numberOfItems;
		
		if (totalCost <= this.accountBalance) {
			this.accountBalance -= totalCost;
		}
		
	}
	
}
