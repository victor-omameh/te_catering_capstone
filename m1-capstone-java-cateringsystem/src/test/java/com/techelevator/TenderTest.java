package com.techelevator;
import org.junit.*;

import com.techelevator.tender.Tender;
public class TenderTest {

	private Tender tender;
	
	
	@Before
	public void setUp() {
		tender = new Tender();
	}
	
	/*
	 * add 100
	 * add 5000
	 * add 5001
	 * add 1 when account balance = 5000
	 * add negative
	 * add 0
	 */
	
	@Test
	public void add_100() {
		tender.addMoney(100);
		double result = tender.currentAccountBalance();
		Assert.assertEquals(100, result, 0.00);
	}
	
	@Test
	public void add_5000() {
		tender.addMoney(5000);
		double result = tender.currentAccountBalance();
		Assert.assertEquals(5000, result, 0.00);
	}
	
	@Test
	public void add_100_balance_200() {
		tender.addMoney(200);
		tender.addMoney(100);
		double result = tender.currentAccountBalance();
		Assert.assertEquals(300, result, 0.00);
	}
	
	@Test
	public void add_5000_balance_1() {
		tender.addMoney(5000);
		tender.addMoney(1);
		double result = tender.currentAccountBalance();
		Assert.assertEquals(5000, result, 0.00);
	}
	
	@Test
	public void add_5001() {
		tender.addMoney(5001);
		double result = tender.currentAccountBalance();
		Assert.assertEquals(0, result, 0.00);
	}
	
	@Test
	public void add_negative() {
		tender.addMoney(50);
		tender.addMoney(-5);
		double result = tender.currentAccountBalance();
		Assert.assertEquals(50, result, 0.00);
	}
	
	@Test
	public void add_zero() {
		tender.addMoney(50);
		tender.addMoney(0);
		double result = tender.currentAccountBalance();
		Assert.assertEquals(50, result, 0.00);
	}
}
