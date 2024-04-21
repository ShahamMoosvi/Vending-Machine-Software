package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static com.techelevator.Application.inventory;

public class Inventory {
    // Variables
    List<VendingItem> vendingItems = new ArrayList<>();
    Scanner fileInput;

    // Constructor which scans the inventory file for items
    public Inventory(File inventoryFile) {
        try {
            fileInput = new Scanner(inventoryFile);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            throw new RuntimeException(e);
        }
        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();
            String[] splitLine = line.split("\\|");
            String slot = splitLine[0];
            String name = splitLine[1];
            double price = Double.parseDouble(splitLine[2]);
            String type = splitLine[3];
            vendingItems.add(new VendingItem(slot, name, price, type));
        }
    }

    // Method to take slot string and return VendingItem
    public VendingItem selectVendingItem(String slot) {
        VendingItem vendingSelection = null;
        for (VendingItem item : inventory.getVendingItems()) {
            if (slot.toUpperCase().equals(item.getSlot())) {
                vendingSelection = item;
                break;
            }
        }
        return vendingSelection;
    }

    // Getter
    public List<VendingItem> getVendingItems() {
            return vendingItems;
    }

}
