package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.ItemCount;


public class Demo {

	public static void main(String[] args) throws FileNotFoundException {

		
		Inventory test = new Inventory("cateringsystem.csv");
		//System.out.println(test.scannedIventory());
		
//		List<String> testList = test.scannedIventory();
//		for (String line : testList) {
//			System.out.println(line);
//		}
		
		Map<String, ItemCount> testMap = test.getInventory();
		for (Entry<String, ItemCount> itemEntry : testMap.entrySet()) {
			System.out.print(itemEntry.getKey() + "  ");
			System.out.print(itemEntry.getValue().getItem().getName() + " ");
			System.out.print("$" + itemEntry.getValue().getItem().getPrice());
			System.out.println(" - " + itemEntry.getValue().getItemCount());
		}
		
		
		
//		Beverage coke = new Beverage("Coke", 1.50);
//		
//		System.out.println(coke.getName() + " : " + coke.getPrice());

	}

}
