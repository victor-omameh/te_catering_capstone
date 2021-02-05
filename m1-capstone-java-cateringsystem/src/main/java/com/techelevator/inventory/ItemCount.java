package com.techelevator.inventory;

public class ItemCount {

	private int itemCount = 50;
	private InventoryItem item; 
	
	public ItemCount(InventoryItem item) {
		this.item = item;
	}

	public int getItemCount() {
		return itemCount;
	}

	public InventoryItem getItem() {
		return item;
	}
	
	
	
}
