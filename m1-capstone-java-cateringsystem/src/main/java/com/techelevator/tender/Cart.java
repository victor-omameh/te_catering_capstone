package com.techelevator.tender;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import com.techelevator.inventory.ItemCount;

public class Cart{

	private String itemID;
	private int quantity;
	private Map<String, ItemCount> shoppingCart;
	
	public Cart() {};
		

	public String getItemID() {
		return itemID;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public Map<String, ItemCount> getShoppingCart() {
		return shoppingCart;
	}


	public void addToCart(String itemID, int quantity, Map<String, ItemCount> menu){
		Map<String, ItemCount> newShoppingCart = new LinkedHashMap<String, ItemCount>();
		
		for (Entry<String, ItemCount> itemEntry : menu.entrySet()) {
			if (itemEntry.getKey().equalsIgnoreCase(itemID)) {
				newShoppingCart.put(itemEntry.getKey(), itemEntry.getValue());
			}
		}
		this.quantity = quantity;
		this.shoppingCart = newShoppingCart;
	}
	
	public double getCartTotoal() {
		double cartTotal = 0.00;
		
		for (Entry<String, ItemCount> itemEntry : this.shoppingCart.entrySet()) {
			cartTotal += itemEntry.getValue().getItem().getPrice();
		}
		return cartTotal;
	}
	
}
