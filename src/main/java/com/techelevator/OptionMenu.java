package com.techelevator;

import java.util.List;

import static com.techelevator.Application.*;

public class OptionMenu extends Menu {
    // Variables
    private List<String> menuOptions;
    private int selection;

    // Constructor
    public OptionMenu(String title, List<String> menuOptions) {
        super(title);
        this.menuOptions = menuOptions;
    }

    // Methods
    public void displayMenu() {
        super.displayTitle();
        int optionNumber = 0;
        if (nextMenu.equals(purchaseMenu)) {
            System.out.printf("Current Money Provided: $%.2f\n\n", vendingMoney.getUserBalance());
        }
        for (String option : this.menuOptions) {
            optionNumber++;
            System.out.println("(" + optionNumber + ") " + option);
        }
        System.out.print("Please make a selection: ");
        try {
            this.setSelection(userInput.nextInt());
        } catch (Exception e) {
            this.setSelection(0);
        } finally {
            userInput.nextLine();
        }
        System.out.println();
    }

    // Getters and Setters
    public int getSelection() { return selection; }
    public void setSelection(int selection) { this.selection = selection; }
}
