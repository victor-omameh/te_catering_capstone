package com.techelevator;

import com.techelevator.inventory.Entree;
import com.techelevator.inventory.InventoryItem;
import com.techelevator.inventory.ItemCount;
import org.junit.*;

public class ItemCountTest {
	
	private ItemCount itemCount;
	
	@Before
	public void setup() {
		InventoryItem pizza = new Entree("cheese pizza", 8.50);
		itemCount = new ItemCount(pizza);
	}
	
	@Test
	public void returns_correct_item_count() {
		int numberOfItems = itemCount.getItemCount();
		Assert.assertEquals(50, numberOfItems);
		
	}
	
	@Test
	public void returns_correct_item_name() {
		InventoryItem pizza = new Entree("cheese pizza", 8.50);
		itemCount = new ItemCount(pizza);
		
		InventoryItem nameOfItem = itemCount.getItem();
		Assert.assertEquals(pizza, nameOfItem);
	}
}

