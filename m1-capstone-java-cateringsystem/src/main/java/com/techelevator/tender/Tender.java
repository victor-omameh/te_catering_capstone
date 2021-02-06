package com.techelevator.tender;

public class Tender {

	private double accountBalance;
	
	public Tender() {};

	public double currentAccountBalance() {
		return accountBalance;
	}
	
	public double addMoney(int amountToAdd) {
		
		if ((this.accountBalance < 5000) && (amountToAdd > 0)) {
			if (!(this.accountBalance + amountToAdd > 5000)) {
				this.accountBalance += amountToAdd;
			}
		}
		return this.accountBalance;
	}
	
	public void addToCart(String itemID, int quantity) {
		
	}
	
}
