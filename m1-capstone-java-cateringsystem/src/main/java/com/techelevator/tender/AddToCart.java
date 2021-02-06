package com.techelevator.tender;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import com.techelevator.inventory.ItemCount;

public class AddToCart{

	private String itemID;
	private int quanity;
	
	public AddToCart() {};
		

	public String getItemID() {
		return itemID;
	}

	public int getQuanity() {
		return quanity;
	}
	
	public boolean checkIfProductExists(String itemID, Map<String, ItemCount> menu) {
		boolean productExists = false;
		
		for (Entry<String, ItemCount> itemEntry : menu.entrySet()) {
			if (itemEntry.getKey().equalsIgnoreCase(itemID)) {
				productExists = true;
			}
		}
		return productExists;
	}
	
	public String productDoesNotExistErrorMessage() {
		return "***Error: Please select a different Item ID***";
	}
	

	public Map<String, ItemCount> addToCart(String itemID, int quanity, Map<String, ItemCount> menu){
		Map<String, ItemCount> shoppingCart = new LinkedHashMap<String, ItemCount>();
		
		for (Entry<String, ItemCount> itemEntry : menu.entrySet()) {
			if (itemEntry.getKey().equalsIgnoreCase(itemID)) {
				shoppingCart.put(itemEntry.getKey(), itemEntry.getValue());
			}
		}
		return shoppingCart;
	}
	
}
