package com.techelevator;

import org.junit.*;

import com.techelevator.inventory.Beverage;


public class BeverageTest {
	private Beverage beverage;
	
	@Before
	public void setup() {
		beverage = new Beverage("water", .50);
	}
	
	@Test
	public void returns_correct_name() {
		String beverageName = beverage.getName();
		Assert.assertEquals("water", beverageName);
	}

	
	@Test
	public void returns_correct_price() {
		double beveragePrice = beverage.getPrice();
		Assert.assertEquals(.50, beveragePrice, 0.00);
	}

}
