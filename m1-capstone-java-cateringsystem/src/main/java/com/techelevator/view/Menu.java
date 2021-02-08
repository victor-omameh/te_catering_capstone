package com.techelevator.view;

import java.io.File;
import java.util.List;
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
		int mainMenuSelection = 0;
		
		while (mainMenuSelection == 0) {
			System.out.println("(1) Display Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");
			System.out.println("Please enter a number: ");
			
			String userSelection = userInput.nextLine();
			
			try {
				mainMenuSelection = Integer.parseInt(userSelection);
			} catch (NumberFormatException e)  {
				System.out.println("***Error: Please enter 1, 2 or 3***");
				mainMenuSelection = 0;
			}
			
			if (mainMenuSelection < 1 && mainMenuSelection > 3) {
				System.out.println("***Error: Please enter 1, 2 or 3***");
				mainMenuSelection = 0;
			}
			
		}
		return mainMenuSelection;
		
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
	
	public int purchaseMenuSelection() {
		
		int selectedNumber = 0;
		
		while (selectedNumber == 0) {
			System.out.println("(1) Add Money");
			System.out.println("(2) Select Products");
			System.out.println("(3) Complete Transaction");
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
	
	public int addMoney() {
		int amountToAdd = 0;
		
		boolean addedIncorrectValue = true;
		while(addedIncorrectValue) {
			
			System.out.println("How much would you like to add? ");
			String userSelection = userInput.nextLine();
			
			try {
				amountToAdd = Integer.parseInt(userSelection);
				addedIncorrectValue = false;
			} catch (NumberFormatException e)  {
				System.out.println("***Error: Please enter a whole dollar amount***");
				amountToAdd = 0;
			}
			
			if (amountToAdd > 5000) {
				System.out.println("***Error: Account Balance cannot exceed $5,000***");
				addedIncorrectValue = true;
			}
		}
		return amountToAdd;
	}
	
	public void displayCurrentBalance(double currentBalance) {
		System.out.println("Your current balance is now: " + currentBalance);
	}
	
	public String selectionToAddToCart() {
		
		String selectedMenuItem = null;
		System.out.println("Please enter the Item ID: ");
		selectedMenuItem = userInput.nextLine();
		
		return selectedMenuItem;
	}
	
	public void displayItemNotFound() {
		System.out.println("***Item Not Found***");
	}
	
	public int selectedQuantityToAdd() {
		
		int amountToAddToCart = 0;
		
		boolean incorrectValue = true;
		while (incorrectValue) {
			System.out.println("Please enter the quantity: ");
			String userSelection = userInput.nextLine();
			
			try {
				amountToAddToCart = Integer.parseInt(userSelection);
				incorrectValue = false;
			} catch (NumberFormatException e)  {
				System.out.println("***Error: Please enter a whole dollar amount***");
				amountToAddToCart = 0;
			}
			
			if (amountToAddToCart > 50) {
				System.out.println("***Error: Account Balance cannot exceed $5,000***");
				incorrectValue = true;
			}
		}
		return amountToAddToCart;
	}
	
	public void displayCart(double cartTotal, double accountBalance, List<String> cartDisplay) {
		for (String cartItem : cartDisplay) {
			System.out.println(cartItem);
		}
		System.out.println("Cart Total: $" + cartTotal);
		System.out.println("Change Back: $" + accountBalance);
	}
	
	
	public void displayPrompt(String prompt) {
		System.out.println(prompt);
	}

	
	public void goodbye() {
		System.out.println("Thank You! - To log back in, please re-run the app");
	}

	
}
