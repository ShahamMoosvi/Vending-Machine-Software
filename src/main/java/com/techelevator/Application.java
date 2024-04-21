package com.techelevator;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Application {
	static Scanner userInput = new Scanner(System.in);
	public static final int APP_WIDTH = 36;
	static OptionMenu mainMenu = new OptionMenu("Main Menu",
			List.of("Display Vending Machine Items", "Purchase Menu", "Exit the App"));
	static OptionMenu purchaseMenu = new OptionMenu("Purchase Menu",
			List.of("Feed Money", "Select Product", "Finish Transaction"));
	static ItemMenu itemMenu = new ItemMenu("Item Menu");
	public static Menu nextMenu = mainMenu;
	static String itemSelection = "";
	static Inventory inventory = new Inventory(new File("vendingmachine.csv"));
	static Money vendingMoney = new Money();
	static TransactionLog appLog = new TransactionLog();


	public static void main(String[] args) {
		applicationTitle();
		do {
			nextMenu.displayMenu();
			switch (nextMenu.toString()) {
				case "Main Menu":
					switch (mainMenu.getSelection()) {
						case 1: // Display Vending Machine Items
							nextMenu = itemMenu; break;
						case 2: // Purchase Menu
							nextMenu = purchaseMenu; break;
						case 3: // Exit the App
							nextMenu = null; break;
						case 4: // Sales Report (hidden from user)
							appLog.salesReport();
							System.out.println("Sales report generated.");
							break;
						default:
							System.out.println("Invalid selection. Please try again."); break;
					}
					break;
				case "Purchase Menu":
					switch (purchaseMenu.getSelection()) {
                        case 1: // Feed Money
                            System.out.print("\nPlease insert whole dollars only." +
									"\nAmount inserted: $");
                            int feedAmount;
                            try {
                                feedAmount = userInput.nextInt();
                                vendingMoney.feedDollars(feedAmount);
                            } catch (Exception e) {
                                System.err.println("Invalid dollar amount.");
								break;
                            } finally {
								userInput.nextLine();
							}
                            appLog.logTransaction("FEED MONEY:",
									feedAmount, vendingMoney.getUserBalance());
                            break;
                        case 2: // Select Product
                            itemMenu.displayMenu();
                            System.out.print("Please select an item by slot number: ");
                            itemSelection = userInput.nextLine().toUpperCase();
							VendingItem selection;
							try {
								selection = inventory.selectVendingItem(itemSelection);
								if (selection == null) {
									throw new Exception();
								}
							} catch (Exception e) {
								System.err.println("Invalid selection. Please try again.");
								break;
							}
							if (selection.getQuantity() == 0) {
								System.out.println("\nItem is SOLD OUT"); break;
							} else if (vendingMoney.getUserBalance() >= selection.getPrice()) {
								selection.sellOne();
								vendingMoney.debitUserBalance(selection.getPrice());
								appLog.logTransaction(selection.getName() + " " +
										itemSelection, selection.getPrice(),
										vendingMoney.getUserBalance());
                                System.out.printf("\nDispensing: %s  $%.2f" +
										"\nRemaining balance: $%.2f\n\n", selection.getName(),
										selection.getPrice(), vendingMoney.getUserBalance());
								System.out.println(selection.snackMessage());
                            } else {
								System.out.println("Insufficient funds. Please feed more money.");
                            }
                            break;
                        case 3: // Finish Transaction
                            nextMenu = mainMenu;
                            appLog.logTransaction("GIVE CHANGE:",
									vendingMoney.giveChangeCoins(), vendingMoney.getUserBalance());
							System.out.printf("Remaining balance: $%.2f\n",
									vendingMoney.getUserBalance());
                            break;
                    } break;
				case "Item Menu":
					nextMenu = mainMenu; break;
				default:
					System.out.println("No menu selected. Exiting...");
					nextMenu = null; break;
			}
		} while (nextMenu != null);
	}

	public static void applicationTitle() {
		String corner1 = "//";
		String corner2 = "\\\\";
		String side = "||";
		String appTitle = "Welcome to VendoMatic 800";
		String top = new String(new char[APP_WIDTH - corner1.length() - corner2.length() - 2]).replace("\0", "=");
		String padding = new String(new char[(APP_WIDTH - appTitle.length() - side.length() * 2) / 2]).replace("\0", " ");
		System.out.printf(" %s%s%s\n%s%s%s%s%s\n %s%s%s\n",
				corner1, top, corner2, side, padding, appTitle,
				padding + (appTitle.length() % 2 == APP_WIDTH % 2 ? "" : " "),
				side, corner2, top, corner1);
		nextMenu = mainMenu;
	}
}
