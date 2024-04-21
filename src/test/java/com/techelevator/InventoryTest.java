package com.techelevator;

import org.junit.Test;
import java.io.File;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class InventoryTest {

    @Test
    public void testInventoryConstructor() {

        //Arrange
        File inventoryFile = new File("vendingmachine.csv");

        //Act
        Inventory inventory = new Inventory(inventoryFile);

        //Assert
        assertEquals(16, inventory.getVendingItems().size());
    }

    @Test
    public void testSelectVendingItem() {

        //Arrange
        File inventoryFile = new File("vendingmachine.csv");
        Inventory inventory = new Inventory(inventoryFile);

        //Assert
        assertEquals("Potato Crisps", inventory.selectVendingItem("A1").getName());
        assertEquals("Grain Waves", inventory.selectVendingItem("A3").getName());
        assertEquals("Cowtales", inventory.selectVendingItem("B2").getName());
        assertEquals("Crunchie", inventory.selectVendingItem("b4").getName());
        assertEquals("Cola", inventory.selectVendingItem("C1").getName());
        assertEquals("Mountain Melter", inventory.selectVendingItem("C3").getName());
        assertEquals("Little League Chew", inventory.selectVendingItem("D2").getName());
        assertEquals("Triplemint", inventory.selectVendingItem("d4").getName());
        assertNull(inventory.selectVendingItem("Ee"));
    }
}
