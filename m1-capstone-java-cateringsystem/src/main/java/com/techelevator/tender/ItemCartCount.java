package com.techelevator.tender;

import com.techelevator.inventory.InventoryItem;

public class ItemCartCount {

	private int itemCartCount = 0;
	private InventoryItem item; 
	
	public ItemCartCount(InventoryItem item) {
		this.item = item;
	}

	public int getItemCartCount() {
		return itemCartCount;
	}

	public InventoryItem getItem() {
		return item;
	}
	
	public void updateItemCartCount(int quantityToBuy) {
				itemCartCount += quantityToBuy;
	}
	
	
}
