package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.integration.DTO.ItemDTO;
import se.kth.iv1350.pointofsale.integration.DTO.SaleDTO;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a receipt, which proves the payment of one sale.
 */
public class Receipt {
    private final LocalTime timeOfSale;
    private final Map<String, Integer> soldItemsCount;

    /**
     * Creates a new instance of the Receipt class with the specified sale time.
     *
     * @param timeOfSale The time when the sale occurred.
     */
    public Receipt(LocalTime timeOfSale) {
        this.timeOfSale = timeOfSale;
        this.soldItemsCount = new HashMap<>();
    }

    private String formatTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }

    /**
     * Initiates the creation of the receipt for the specified sale and total price.
     *
     * @param sale  The sale for which the receipt is being generated.
     */
    public void initiateReceipt(SaleDTO sale) {
        System.out.println("\nReceipt:");
        System.out.println("Sale started at: " + formatTime(timeOfSale));
        System.out.println("------------------------------");

        System.out.println("\nItems:");

        for (ItemDTO item : sale.getSoldItems()) {
            soldItemsCount.put(item.getName(), soldItemsCount.getOrDefault(item.getName(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : soldItemsCount.entrySet()) {
            String itemName = entry.getKey();
            int itemCount = entry.getValue();
            double itemPrice = sale.getPriceForItem(itemName);
            double VATrate = sale.getVATForItem(itemName);

            System.out.printf("%-15s %d x $%-8.2f $%-8.2f VAT: %-8.2f%n", itemName, itemCount, itemPrice, itemPrice * itemCount, VATrate);

        }
        System.out.println("------------------------------");
    }
}