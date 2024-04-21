package com.techelevator;


import static com.techelevator.Application.inventory;

public class ItemMenu extends Menu {

    // Constructor
    public ItemMenu(String title) {
        super(title);
    }

    // Methods to display inventory items
    public void displayMenu() {
        super.displayTitle();
        System.out.printf("%-6s%-20s%-7s%-3s\n",
                "Slot", "Snack", "Price", "Qty");
        MenuItem(inventory);
    }

    private void MenuItem(Inventory inventory) {
        for (VendingItem item : inventory.getVendingItems()) {
            System.out.printf(" %-5S%-20s%5.2f  %2s\n",
                    item.getSlot(), item.getName(), item.getPrice(),
                    (item.getQuantity()==0 ? "SOLD OUT" : item.getQuantity()));
        }

    }
}
