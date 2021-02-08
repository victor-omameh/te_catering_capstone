package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.ItemCount;
import com.techelevator.tender.Cart;
import com.techelevator.tender.Tender;
import com.techelevator.view.Menu;


public class CateringSystemCLI {

	
	private Menu menu;
	private Inventory inventory;
	private Tender tender;
	private Cart cart = new Cart();;
	private Map<String, ItemCount> menuItems;

	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	
	public void run() {
		
		Audit log = new Audit();
		try {
			log.createLogFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		menu.greetings();
		
		boolean fileDoesNotExist = true;
		while (fileDoesNotExist) {
			
			String filename = menu.promptUserForFile("Inventory File name: ");
			
			inventory = new Inventory(filename);
			try {
				menuItems = inventory.getInventory();
			} catch (FileNotFoundException e) {
				menu.showErrorToUser();
			}
			
			
			boolean checkingFile = menu.checkingFileExists(inventory.getInventoryFile());
			
			if(checkingFile) {
				fileDoesNotExist = false;
			}
		}
		
		boolean systemRun = true;
		while (systemRun) {
			
			int mainMenuSelection = menu.getMainMenuSelection();
			
			
			if (mainMenuSelection == 1) {
				menu.displayMenuItems(inventory.updateInventory(null, 0, menuItems));;
			} else if ( mainMenuSelection == 2) {
				
				boolean makingPurchaseMenuSelections = true;
				while (makingPurchaseMenuSelections) {
					
					int purchaseMenuSelection = menu.purchaseMenuSelection();
					
					if (purchaseMenuSelection == 1) {
						int amountToAdd = menu.addMoney();
						tender = new Tender();
						tender.addMoney(amountToAdd);
						menu.displayCurrentBalance(tender.currentAccountBalance());
						try {
							log.logAddMoney(amountToAdd, tender.currentAccountBalance());
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (purchaseMenuSelection == 2) {
						menu.displayMenuItems(inventory.updateInventory(null, 0, menuItems));

						String itemToAddToCart = menu.selectionToAddToCart();
						itemToAddToCart = itemToAddToCart.toUpperCase();
			
						if (inventory.checkIfProductExists(itemToAddToCart)) {
							
							if (inventory.chechkingIfNotSoldOut(itemToAddToCart)) {
								
								int quantityToAddToCart = menu.selectedQuantityToAdd();
								
								if (inventory.checkingIfSufficientStock(itemToAddToCart, quantityToAddToCart)) {
									
									if (tender.checkingSufficientFunds(inventory.updateInventory(null, 0, menuItems).get(itemToAddToCart).getItem().getPrice(), quantityToAddToCart)) {
										
										try {
											
											//add to cart
											cart.addToCart(itemToAddToCart, quantityToAddToCart, inventory.updateInventory(null, 0, menuItems));
											
											//updating stock level
											menuItems = inventory.updateInventory(itemToAddToCart, quantityToAddToCart, menuItems);
											//inventory.getInventory().get(itemToAddToCart).updateItemCount(quantityToAddToCart);
											
											//updating account balance
											tender.updateBalance(inventory.getInventory().get(itemToAddToCart).getItem().getPrice(), quantityToAddToCart);
											
											//update log
											try {
												log.logAddToCart(quantityToAddToCart, inventory.updateInventory(null, 0, menuItems).get(itemToAddToCart).getItem().getName(), itemToAddToCart, inventory.updateInventory(null, 0, menuItems).get(itemToAddToCart).getItem().getPrice(), tender.currentAccountBalance());
											} catch (IOException e) {
												e.printStackTrace();
											}
											
										} catch (FileNotFoundException e) {
											menu.showErrorToUser();
										}
									} else {
										menu.displayPrompt(tender.insufficientFundsMessage());
									}
								} else {
									menu.displayPrompt(inventory.insufficientStockMessage());
								}
								
							} else {
								menu.displayPrompt(inventory.productIsSoldOut());
							}	
						} else {
							menu.displayPrompt(inventory.productDoesNotExistErrorMessage());
						}			
					} else if (purchaseMenuSelection == 3) {
						menu.displayCart(tender.getBill(), tender.currentAccountBalance(), cart.getCartDisplay());
						try {
							log.logCheckout(tender.currentAccountBalance());
						} catch (IOException e) {
							e.printStackTrace();
						}
						makingPurchaseMenuSelections = false;
						tender.resetAccountBalance();
					}
						
					}
				} else {
					menu.goodbye();
					systemRun = false;
				}
	 
		}
	}

	
	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
