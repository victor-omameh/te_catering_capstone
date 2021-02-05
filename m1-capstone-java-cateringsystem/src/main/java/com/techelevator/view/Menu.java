package com.techelevator.view;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.techelevator.inventory.ItemCount;

/*
 * This is the only class that should have any usage of System.out or System.in
 */
public class Menu {
	
	private static final Scanner userInput = new Scanner(System.in);
	
	public void greetings () {
		System.out.println();
		System.out.println("                Welcome to\n"
				+ "             THE CATERING APP!\n"
				+ "             \n"
				+ "             brought to you by\n"
				+ "            Weyland Corporation");
		System.out.println("-----------------------------------------------");
		System.out.println();
		System.out.println("To begin using The Catering App, you need to upload a menu file!");

	}
	
	public String promptUserForFile(String prompt){
		System.out.println(prompt);
		return userInput.nextLine();
	}
	

	public boolean checkingFileExists(File inventoryFile) {
		boolean fileExists = false;
		
		if ((!inventoryFile.exists()) || (!inventoryFile.isFile())) {
			System.out.println();
			System.out.println("**Sorry, I cannot find that file in our system. Please try a different file name.**");
			System.out.println();
		} else {
			
			fileExists = true;
		}
		
		return fileExists;
	}
	
	public int getMainMenuSelection() {
		int selectedNumber = 0;
		
		while (selectedNumber == 0) {
			System.out.println("(1) Display Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");
			System.out.println("Please enter a number: ");
			
			String userSelection = userInput.nextLine();
			
			try {
				selectedNumber = Integer.parseInt(userSelection);
			} catch (NumberFormatException e)  {
				System.out.println("***Error: Please enter 1, 2 or 3***");
				selectedNumber = 0;
			}
			
			if (selectedNumber < 1 && selectedNumber > 3) {
				System.out.println("***Error: Please enter 1, 2 or 3***");
				selectedNumber = 0;
			}
			
		}
		return selectedNumber;
		
	}
	
	public void displayMenuItems(Map<String, ItemCount> menuItems) {
		for (Entry<String, ItemCount> itemEntry : menuItems.entrySet()) {
			System.out.print(itemEntry.getKey() + "  ");
			System.out.print(itemEntry.getValue().getItem().getName() + " ");
			System.out.print("$" + itemEntry.getValue().getItem().getPrice());
			System.out.println(" - " + itemEntry.getValue().getItemCount());
		}
	}
	
	public void showErrorToUser() {
		System.out.println("**** Sorry, something went wrong with the file, please re-run the app and try again ****");
	}

	
}
