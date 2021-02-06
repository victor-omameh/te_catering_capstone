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
	
	public void updateItemCount(int quantityToBuy) {
		
		if(this.itemCount > 0) {
			if(this.itemCount - quantityToBuy >= 0) {
				this.itemCount -= quantityToBuy;
			}
		}
	}
	
}
