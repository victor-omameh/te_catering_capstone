package com.techelevator.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

	private File inventoryFile;
	private Map<String, ItemCount> inventory;

	public Inventory(String fileName){
		this.inventoryFile = new File(fileName);
	}

	
	public File getInventoryFile() {
		return inventoryFile;
	}

	public void setInventoryFile(String fileName) {
		this.inventoryFile = new File(fileName);
	}
	
	// creating inventory map
	public Map<String, ItemCount> read() throws FileNotFoundException {
		List<String>  linesFromInventoryFile = scannedIventory();
		inventory = new LinkedHashMap<String, ItemCount>();
		
		for (String fileLine : linesFromInventoryFile) {
			String[] details = fileLine.split("\\|");
			String itemID = details[0];
			ItemCount ItemCount = createItem(details[3], details[1], Double.parseDouble(details[2]));
			inventory.put(itemID, ItemCount);
		}
		
		return inventory;
	}
	// allowing user to call inventory map
	public Map<String, ItemCount> getInventory() throws FileNotFoundException{
		return read(); 
	}
	
	// sorting items from scanned file into proper categories 
	public ItemCount createItem(String type, String name, double price) {
		InventoryItem item = null;
		
		if (type.equalsIgnoreCase("B")) {
			item = new Beverage(name, price);
		} else if (type.equalsIgnoreCase("E")) {
			item = new Entree(name, price);
		} else if (type.equalsIgnoreCase("A")) {
			item = new Appetizer(name, price);
		} else if (type.equalsIgnoreCase("D")) {
			item = new Dessert(name, price);
		}
		
		return new ItemCount(item);
	}
	
	// scanning inventory
	public List<String> scannedIventory() throws FileNotFoundException{
		List<String> linesFromInventoryFile = new ArrayList<String>();
		
		try (Scanner inventoryFileScanner = new Scanner(inventoryFile)){
			while (inventoryFileScanner.hasNextLine()) {
				linesFromInventoryFile.add(inventoryFileScanner.nextLine());
			}
		}
		
		return linesFromInventoryFile;
	}
	
	
}
