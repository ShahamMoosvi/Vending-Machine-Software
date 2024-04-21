package com.techelevator;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class VendingItemTest {

    @Test
    public void testVendingItemConstructor() {
        //Arrange
        String slot = "C1";
        String name = "Cola";
        double price = 1.25;
        String type = "Drink";

        //Act
        VendingItem vendingItem1 = new VendingItem(slot, name, price, type);

        //Assert
        assertEquals(slot, vendingItem1.getSlot());
        assertEquals(name, vendingItem1.getName());
        assertEquals(price, vendingItem1.getPrice());
        assertEquals(type, vendingItem1.getType());
    }

    @Test
    public void testSnackMessage() {

        //Arrange
        VendingItem drinkSnack = new VendingItem("C1", "Cola", 1.25, "Drink");
        VendingItem chipSnack = new VendingItem("A1", "Potato Crisps", 3.05, "Chip");
        VendingItem gumSnack = new VendingItem("D1", "Chewing Gum", 0.75, "Gum");
        VendingItem candySnack = new VendingItem("B1", "Moonpie", 1.80, "Candy");

        //Assert
        assertEquals("Glug Glug, Yum!", drinkSnack.snackMessage());
        assertEquals("Crunch Crunch, Yum!", chipSnack.snackMessage());
        assertEquals("Chew Chew, Yum!", gumSnack.snackMessage());
        assertEquals("Munch Munch, Yum!", candySnack.snackMessage());
    }
}





