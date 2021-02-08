package com.techelevator.tender;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.techelevator.inventory.Appetizer;
import com.techelevator.inventory.Beverage;
import com.techelevator.inventory.Dessert;
import com.techelevator.inventory.Entree;
import com.techelevator.inventory.InventoryItem;
import com.techelevator.inventory.ItemCount;


public class Cart{

	private Map<String, ItemCartCount> cart = new LinkedHashMap<String, ItemCartCount>();
	private static double cartTotal;
	private static List<String> cartDisplay = new ArrayList<String>();
	private String type;
	private String name;
	private double price;
	
	
	public Cart() {};
		

	public void addToCart(String itemID, int quantity, Map<String, ItemCount> menu){

		
		boolean itemFound = false;
		for (Entry<String, ItemCount> inventoryItem : menu.entrySet()) {
			if (inventoryItem.getKey().equalsIgnoreCase(itemID)) {
				itemFound = true;
				this.type = inventoryItem.getValue().getItem().getItemType();
				this.name = inventoryItem.getValue().getItem().getName();
				this.price = inventoryItem.getValue().getItem().getPrice();
				break;
			}
		}
		if (itemFound == true) {
			if (cart.containsKey(itemID)) {
				for (Entry<String, ItemCartCount> cartItem : cart.entrySet()) {
					if (cartItem.getKey().equalsIgnoreCase(itemID)) {
						
						int itemTotal = cartItem.getValue().getItemCartCount();
						String itemName = cartItem.getValue().getItem().getName();
						String itemType = cartItem.getValue().getItem().getItemType();
						String itemPrice = String.format("$%1.2f", cartItem.getValue().getItem().getPrice());
						String itemTotalPrice = String.format("$%1.2f", cartItem.getValue().getItem().getPrice() * cartItem.getValue().getItemCartCount());
						
						String oldCartLineItem = String.format("%1$-5s %2$-10s %3$-20s %4$-10s %5$-1s", itemTotal, itemType, itemName, itemPrice, itemTotalPrice);
						
						cartItem.getValue().updateItemCartCount(quantity);
					
						itemTotal = cartItem.getValue().getItemCartCount();
						itemTotalPrice = String.format("$%1.2f", cartItem.getValue().getItem().getPrice() * cartItem.getValue().getItemCartCount());
						
						String newCartLineItem = String.format("%1$-5s %2$-10s %3$-20s %4$-10s %5$-1s", itemTotal, itemType, itemName, itemPrice, itemTotalPrice);
						
						cartDisplay.remove(oldCartLineItem);
						cartDisplay.add(newCartLineItem);
					}
				}
			} else {
				ItemCartCount ItemCartCount = createCartItem(itemID, this.name, this.price);
				cart.put(itemID, ItemCartCount);
				cart.get(itemID).updateItemCartCount(quantity);
				
				String totalItemPrice = String.format("$%1.2f", price*quantity);
				String itemPrice = String.format("$%1.2f", price);

				String cartLineItem = String.format("%1$-5s %2$-10s %3$-20s %4$-10s %5$-1s", quantity, type, name, itemPrice, totalItemPrice);
				cartDisplay.add(cartLineItem);
			}
		}
	}
	
	public ItemCartCount createCartItem(String itemID, String name, double price) {
		InventoryItem item = null;
		
		if (type.contains("B")) {
			item = new Beverage(name, price);
		} else if (type.contains("E")) {
			item = new Entree(name, price);
		} else if (type.contains("A")) {
			item = new Appetizer(name, price);
		} else if (type.contains("D")) {
			item = new Dessert(name, price);
		}
		
		return new ItemCartCount(item);
	}
	
	public List<String> getCartDisplay() {
		return cartDisplay;
	}
	
	public double getCartTotal() {
		return cartTotal;
	}
		
}
