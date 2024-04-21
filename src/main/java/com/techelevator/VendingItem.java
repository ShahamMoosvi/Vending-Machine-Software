package com.techelevator;


public class VendingItem {
    // Variables
    String slot;
    String name;
    double price;
    String type;
    int quantity;
    public static final int MAX_ITEM_INVENTORY = 5;

    // Constructor
    public VendingItem(String slot, String name, double price, String type) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = MAX_ITEM_INVENTORY;
    }

    // Methods
    public void sellOne() {if (this.quantity != 0) this.quantity --;}

    public String snackMessage() {
        String keyword = "";
        switch (this.type.toLowerCase()) {
            case "chip": keyword = "Crunch"; break;
            case "candy": keyword = "Munch"; break;
            case "drink": keyword = "Glug"; break;
            case "gum": keyword = "Chew"; break;
            default: System.out.println("No matches found."); break;
        }
        return keyword + " " + keyword + ", Yum!";
    }

    // Getters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getSlot() {
        return slot;
    }
    public String getType() {
        return type;
    }
    public int getQuantity() {return quantity;}
}
