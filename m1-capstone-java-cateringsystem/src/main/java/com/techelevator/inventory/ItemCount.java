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
	
	public int updateItemCount(int quantityToBuy) {
		
		if(this.itemCount > 0) {
			if(this.itemCount - quantityToBuy >= 0) {
				this.itemCount -= quantityToBuy;
			}
		}
		return this.itemCount;
	}
	
	public String soldOut() {
		String soldOut = null;
		if (this.itemCount == 0) {
			soldOut =  "SOLD OUT";
		} 
		return soldOut;
	}
	
	
}
