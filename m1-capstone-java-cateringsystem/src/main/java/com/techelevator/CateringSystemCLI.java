package com.techelevator;

import java.io.FileNotFoundException;

import com.techelevator.inventory.Inventory;
import com.techelevator.view.Menu;

/*
 * This class should control the workflow of the application, but not do any other work
 * 
 * The menu class should communicate with the user, but do no other work
 * 
 * The work of the Catering System should be in other classes that you build and 
 * call from here. 
 */
public class CateringSystemCLI {

	/*
	 * The menu class is instantiated in the main() method at the bottom of this file.  
	 * It is the only class instantiated in the starter code.  
	 * You will need to instantiate all other classes using the new keyword before you can use them.
	 * 
	 * Remember every class and data structure is a data types and can be passed as arguments to methods or constructors.
	 */
	private Menu menu;
	private Inventory inventory;

	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	/*
	 * Your application starts here
	 */
	public void run() {
		
		menu.greetings();
		
		boolean fileDoesNotExist = true;
		while (fileDoesNotExist) {
			
			String filename = menu.promptUserForFile("Inventory File name: ");
			
			inventory = new Inventory(filename);
			
			boolean checkingFile = menu.checkingFileExists(inventory.getInventoryFile());
			
			if(checkingFile) {
				fileDoesNotExist = false;
			}
		}
		while (true) {
			int selectedNumber = menu.getMainMenuSelection();
			if (selectedNumber == 1) {
				try {
					menu.displayMenuItems(inventory.getInventory());
				} catch (FileNotFoundException e) {
					menu.showErrorToUser();
				}
			}
		}
	}

	/*
	 * This starts the application, but you shouldn't need to change it.  
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
