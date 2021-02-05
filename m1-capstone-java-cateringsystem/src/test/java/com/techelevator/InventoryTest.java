package com.techelevator;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


import org.junit.*;

import com.techelevator.inventory.Beverage;
import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.InventoryItem;
import com.techelevator.inventory.ItemCount;

public class InventoryTest {
	private Inventory inventory;
	
	@Before
	public void setup() {
		inventory = new Inventory("cateringsystem.csv");
	}
	
	@Test
	public void returns_correct_map() throws FileNotFoundException {
		//inventory = new Inventory("cateringsystem.csv");
		//ARRANGE
		InventoryItem beverage = new Beverage("Soda", 1.50);
		ItemCount test = new ItemCount(beverage);
		//ACT
		Map<String,ItemCount> expectedResult = new LinkedHashMap<String, ItemCount>();
		expectedResult.put("B1", test);
			
		Map<String, ItemCount> result = inventory.getInventory();
		for(Entry<String, ItemCount> itemEntry : result.entrySet() ) {
			
			
			}
		
		//ASSERT 
		
		
	}
}
