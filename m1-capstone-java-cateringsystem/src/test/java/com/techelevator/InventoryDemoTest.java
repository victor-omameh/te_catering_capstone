package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.ItemCount;

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
		
	}
	
}
