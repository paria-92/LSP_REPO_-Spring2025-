package org.howard.edu.lspfinal.question3;

/**
 * Driver class to demonstrate Template Method pattern with reports.
 */
public class Driver {
    public static void main(String[] args) {
        ReportGenerator sales = new SalesReport();
        ReportGenerator inventory = new InventoryReport();

        sales.generateReport();
        System.out.println();
        inventory.generateReport();
    }
}

