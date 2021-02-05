package com.techelevator;

import org.junit.*;

import com.techelevator.inventory.Appetizer;

public class AppetizerTest {
	private Appetizer appetizer;
	
	@Before
	public void setup() {
		appetizer = new Appetizer("nachos", 10.00);
	}
	
	@Test
	public void returns_correct_name() {
		String appetizerName = appetizer.getName();
		Assert.assertEquals("nachos", appetizerName);
	}

	
	@Test
	public void returns_correct_price() {
		double appetizerPrice = appetizer.getPrice();
		Assert.assertEquals(10.00, appetizerPrice, 0.00);
	}
	
}
