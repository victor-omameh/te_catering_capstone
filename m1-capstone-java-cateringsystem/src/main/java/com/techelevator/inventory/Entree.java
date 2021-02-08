package com.techelevator.inventory;

public class Entree extends InventoryItem{

	public Entree(String name, double price) {
		super(name, price);
	}

	public String getItemType() {
		return "Entree";
	}
	
}
