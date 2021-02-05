package com.techelevator;

import org.junit.*;


import com.techelevator.inventory.Dessert;

public class DessertTest {
	
	private Dessert dessert;
	
	@Before
	public void setup() {
		dessert = new Dessert("Apple Pie", 8.50);
	}
	
	@Test
	public void returns_correct_name() {
		String dessertName = dessert.getName();
		Assert.assertEquals("Apple Pie", dessertName);
	}

	
	@Test
	public void returns_correct_price() {
		double dessertPrice = dessert.getPrice();
		Assert.assertEquals(8.50, dessertPrice, 0.00);
	}


}
