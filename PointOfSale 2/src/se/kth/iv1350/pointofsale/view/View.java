package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.controller.Controller;
import se.kth.iv1350.pointofsale.integration.DTO.ItemDTO;

/**
 * Represents the user interface of the Point of Sale system.
 * This class provides a placeholder for the real view.
 * It contains a hardcoded execution with calls to all system operation in the controller.
 */

public class View {
    private Controller contr;

    /**
     * Creates a new instance
     *
     * @param contr The controller used for communication with other layers.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution() {
        System.out.println("\nA new sale has been started.\n");
        contr.newSale();
        scanItem();
        endSale();
    }

    /**
     *  Simulates scanning of items and displays their details.
     */
    private void scanItem() {
        System.out.println("The entered item with ID: 987654, quantity: 2");
        ItemDTO item1 = contr.registerItem("987654",2);
        System.out.println("Scanned item: \n" + "Item ID: " + item1.getItemIdentifier() + ", Item name: " +item1.getName() +
                           ", Price: " + item1.getPrice() + ", Quantity: " + item1.getQuantity());

        System.out.println("\nThe entered item with ID: 654321, quantity: 1");
        ItemDTO item2 = contr.registerItem("654321",1);
        System.out.println("Scanned item: \n" + "Item ID: " + item2.getItemIdentifier() + ", Item name: " +item2.getName() +
                ", Price: " + item2.getPrice() + ", Quantity: " + item2.getQuantity());
    }

    /**
     * Finalizes the sale, calculates change, and generates a receipt.
     */
    private void endSale() {
        System.out.println("\nFinalizing the sale.\n");
        double totalAmount = contr.getTotalPrice();
        System.out.println("Total amount: $" + totalAmount);
        int customerPayment = 1450;
        System.out.println("Customer pays: $" + customerPayment);
        double change = contr.concludeSale(customerPayment);
        System.out.println("The customer will receive $" + change + " in change.");
        contr.generateReceipt();
        contr.sendSaleInfo();
    }
}
