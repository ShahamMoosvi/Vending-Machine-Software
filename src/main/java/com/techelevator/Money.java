package com.techelevator;

public class Money {
    // Variables
    private final int QUARTER = 25;
    private final int DIME = 10;
    private final int NICKEL = 5;
    private int userBalance;
    private int coinsQuarter = 0;
    private int coinsDime = 0;
    private int coinsNickel = 0;

    // Constructor
    public Money() {
        this.userBalance = 0;
    }

    // Methods
    public void debitUserBalance(double purchaseAmount) {
        userBalance -= (int)(purchaseAmount * 100);
    }

    public void feedDollars(int feedDollars) {
        if (feedDollars > 0 ) {
            userBalance += (int)((feedDollars * 100.00)+0.05);
        }
    }

    public double giveChangeCoins() {
        double givenChange = this.getUserBalance();
        if (userBalance >= QUARTER){coinsQuarter = userBalance / QUARTER;
            userBalance = (userBalance % QUARTER);}
        if (userBalance >= DIME) {coinsDime = userBalance / DIME;
            userBalance =  userBalance % DIME;}
        if (userBalance >= NICKEL) {coinsNickel = userBalance / NICKEL;
            userBalance = userBalance % NICKEL;}
        System.out.printf("Change: Quarters: %d Dimes: %d Nickels: %d\n",
                coinsQuarter, coinsDime, coinsNickel);
        return givenChange;
    }

    // Getter
    public double getUserBalance() {
        return userBalance / 100.0;
    }

}