package com.techelevator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import static com.techelevator.Application.inventory;
import static com.techelevator.VendingItem.MAX_ITEM_INVENTORY;

public class TransactionLog {

    //Methods
    public void logTransaction(String action, double amount, double balance) {
        
        String filePath= "src/main/java/com/techelevator/Log.txt";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(filePath,true))){
            logWriter.printf("%s  %s  $%.2f  $%.2f\n", dtf.format(now), action, amount, balance);
        } catch(FileNotFoundException e){
            System.err.println("Cannot open the file for writing.");
        }
    }

    public void salesReport() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-hhmmss");
        LocalDateTime now = LocalDateTime.now();
        String filePath= "src/main/java/com/techelevator/" + dtf.format(now) + "-report.txt";
        double totalSales = 0.0;
        try (PrintWriter reportWriter = new PrintWriter(new FileOutputStream(filePath))){
            for (VendingItem item : inventory.getVendingItems()) {
                reportWriter.printf("%s|%d\n", item.getName(),
                        MAX_ITEM_INVENTORY - item.getQuantity());
                totalSales += item.getPrice() * (MAX_ITEM_INVENTORY - item.getQuantity());
            }
            reportWriter.printf("\n*TOTAL SALES** $%.2f\n", totalSales);
        } catch(FileNotFoundException e){
            System.err.println("Cannot open the file for writing.");
        }
    }
}
