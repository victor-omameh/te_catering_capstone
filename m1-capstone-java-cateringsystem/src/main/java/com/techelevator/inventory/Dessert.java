package com.techelevator.inventory;

public class Dessert extends InventoryItem{

	public Dessert(String name, double price) {
		super(name, price);
	}

	public String getItemType() {
		return "Dessert";
	}
	
}
