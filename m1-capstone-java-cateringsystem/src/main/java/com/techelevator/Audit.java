package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Audit {

	private File logFile;
	private Date date = new java.util.Date();
	
	public Audit() {
		
	}
	
	public void createLogFile() throws IOException {
		this.logFile = new File("Log.txt");
		this.logFile.createNewFile();
	}
	
	
	public void logAddMoney(double amountAdded, double currentBalance) throws IOException {
	
		FileWriter logWriter = new FileWriter("Log.txt", true);
		logWriter.write(date + " ADD MONEY: $" + amountAdded+ " $" + currentBalance);
		logWriter.close();
	}
	
	
	public void logAddToCart(int quantity, String itemType, String itemID, double itemPrice, double currentBalance) throws IOException {
		
		FileWriter logWriter = new FileWriter("Log.txt", true);
		logWriter.write(date + " " + quantity + " " + itemType + " " + itemID + " $" + itemPrice*quantity + " $" + currentBalance);
		logWriter.close();
		
	}
	
	public void logCheckout(double currentBalance) throws IOException {
		FileWriter logWriter = new FileWriter("Log.txt", true);
		logWriter.write(date + " CHANGE BACK: $" + currentBalance + " $0.00");
		logWriter.close();
	}
}
