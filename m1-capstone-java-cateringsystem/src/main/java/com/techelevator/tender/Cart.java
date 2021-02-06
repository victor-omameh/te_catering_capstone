package com.techelevator.tender;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import com.techelevator.inventory.ItemCount;

public class Cart{

	private String itemID;
	private int quanity;
	private Map<String, ItemCount> shoppingCart;
	
	public Cart() {};
		

	public String getItemID() {
		return itemID;
	}

	public int getQuanity() {
		return quanity;
	}
	
	public Map<String, ItemCount> getShoppingCart() {
		return shoppingCart;
	}


	public void addToCart(String itemID, int quanity, Map<String, ItemCount> menu){
		Map<String, ItemCount> newShoppingCart = new LinkedHashMap<String, ItemCount>();
		
		for (Entry<String, ItemCount> itemEntry : menu.entrySet()) {
			if (itemEntry.getKey().equalsIgnoreCase(itemID)) {
				shoppingCart.put(itemEntry.getKey(), itemEntry.getValue());
			}
		}
		
		this.shoppingCart = newShoppingCart;
	}
	
}
