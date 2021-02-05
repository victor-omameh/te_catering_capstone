package com.techelevator;

import org.junit.*;

import com.techelevator.inventory.Entree;



public class EntreeTest {
	private Entree entree;
		
		@Before
		public void setup() {
			entree = new Entree("Steak", 20.00);
		}
		
		@Test
		public void returns_correct_name() {
			String entreeName = entree.getName();
			Assert.assertEquals("Steak", entreeName);
		}

		
		@Test
		public void returns_correct_price() {
			double entreePrice = entree.getPrice();
			Assert.assertEquals(20.00, entreePrice, 0.00);
		}

}
