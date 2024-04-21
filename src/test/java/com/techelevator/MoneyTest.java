package com.techelevator;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MoneyTest {

    @Test
    public void testMoneyConstructor() {

        //Arrange
        Money money = new Money();

        //Assert
        assertEquals(0.0, money.getUserBalance());
    }

    @Test
    public void testFeedDollars() {

        //Arrange
        Money money = new Money();

        //Act
        money.feedDollars(1);

        //Assert
        assertEquals(1.00, money.getUserBalance());

    }

    @Test
    public void testDebitUserBalance() {

        //Arrange
        Money money = new Money();

        //Act
        money.feedDollars(3);
        money.debitUserBalance(1.45);

        //Assert
        assertEquals(1.55, money.getUserBalance());
    }

    @Test
    public void testGiveChangeCoins() {

        //Arrange
        Money money = new Money();

        //Act
        money.feedDollars(3);
        money.debitUserBalance(1.45);

        //Assert
        assertEquals(1.55, money.giveChangeCoins());
    }
}
