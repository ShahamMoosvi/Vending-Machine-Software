package com.techelevator;

import static com.techelevator.Application.APP_WIDTH;

public abstract class Menu {
    // Variable
    private String title;

    // Constructor
    public Menu(String title) {
        this.title = title;
    }

    // Methods
    public void displayTitle() {
        String divider = new String(new char[(APP_WIDTH - this.title.length() -
                4) / 2]).replace("\0", "-");
        System.out.printf("\n>%s %s%s<\n", divider, this.title +
                (this.title.length() % 2 == APP_WIDTH % 2 ? " " : " -"), divider);
    }

    public abstract void displayMenu();

    @Override
    public String toString() {
        return this.title;
    }
}
