package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.ItemCount;
import com.techelevator.tender.Cart;
import com.techelevator.tender.Tender;

public class InventoryDemoTest {

	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * Testing Inventory class methods which demonstrate that Inventory Class
		 * properly scans file, splits file lines into array and populates Map
		 */
		
		Inventory test = new Inventory("cateringsystem.csv");
		
		Map<String, ItemCount> testMap = test.getInventory();
		for (Entry<String, ItemCount> itemEntry : testMap.entrySet()) {
			System.out.print(itemEntry.getKey() + "  ");
			System.out.print(itemEntry.getValue().getItem().getName() + " ");
			System.out.print("$" + itemEntry.getValue().getItem().getPrice());
			System.out.println(" - " + itemEntry.getValue().getItemCount());
		}
		
		
		boolean testing1 = test.checkIfProductExists("B1");
		if (testing1) {
			System.out.println("Test1 working");
		}
		
		boolean testing2 = test.checkIfProductExists("Z1");
		if (!testing2) {
			System.out.println("Test2 working");
		}
		
		boolean testing3 = test.chechkingIfNotSoldOut("B1");
		if (testing3) {
			System.out.println("Test3 working");
		}
		
		//test creating cart, adding money into account, displaying new balance, adding to cart, checking updated itemCount
		Tender tender = new Tender();
		Cart cart = new Cart();
		
		tender.addMoney(500);
		System.out.println("current balance: " + tender.currentAccountBalance());
		cart.addToCart("B5", 50, test.getInventory());
		
		Map<String, ItemCount> testCart = cart.getShoppingCart();
		for (Entry<String, ItemCount> itemEntry : testCart.entrySet()) {
			System.out.print(itemEntry.getKey() + "  ");
			System.out.print(itemEntry.getValue().getItem().getName() + " ");
			System.out.print("$" + itemEntry.getValue().getItem().getPrice());
			System.out.println(" - " + cart.getQuantity());
		}
		
		
		// update item count
		test.getInventory().get("B5").updateItemCount(50);
		System.out.println(test.getInventory().get("B5").getItemCount() + ": if zero - testing is working");
	
		// check account balance update
		tender.updateBalance(.90, 50);
		System.out.println("current balance: " + tender.currentAccountBalance());
		
		//test NOT sold out is true (item is not sold out)
		
		boolean test4point1 = test.chechkingIfNotSoldOut("B1");
		if (test4point1) {
			System.out.println("NOT SOLD OUT : Test4.1 working");
		} else {
			System.out.println("Test4.1 not working");
		}
		
		
		//Test NOT sold out is false (item is sold out)
		
		boolean testing4 = test.chechkingIfNotSoldOut("B5");
		if (!testing4) {
			System.out.println("SOLD OUT : Test4 working");
		} else {
			System.out.println("Test4 not working");
		}
		
		// checking sufficient stock
		
		boolean testing5 = test.checkingIfSufficientStock("B1", 50);
		if (testing5) {
			System.out.println("Test5 working");
		} else {
			System.out.println("Test5 not working");

		}
		
		// checking insufficient stock
		
		boolean testing6 = test.checkingIfSufficientStock("B1", 60);
		if (!testing6) {
			System.out.println("Test6 working");

		} else {
			System.out.println("Test6 not working");

		}
		
		
	}
	
}
