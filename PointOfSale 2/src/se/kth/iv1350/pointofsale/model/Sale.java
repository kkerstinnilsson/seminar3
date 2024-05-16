package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.integration.DTO.ItemDTO;
import se.kth.iv1350.pointofsale.integration.DTO.SaleDTO;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single sale made by one customer and paid with one payment.
 */
public class Sale {
    private LocalTime timeOfSale;
    private Payment payment;
    private Receipt receipt;
    private SaleDTO saleDTO;
    private List<ItemDTO> saleItems; //ny

    /**
     * Creates a new instance of the Sale class and saves the time of the sale.
     */
    public Sale() {
        timeOfSale = LocalTime.now();
        payment = new Payment();
        receipt = new Receipt(timeOfSale);
        saleDTO = new SaleDTO();
        saleItems = new ArrayList<>(); //ny
    }

    /**
     * Records the sale of an item with the specified quantity.
     *
     * @param item     The item being sold.
     * @param quantity The quantity of the item being sold.
     */
    public void recordSoldItem(ItemDTO item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            saleItems.add(item);
            //cannot use saleDTO new list here 
        }
    } 

    /**
     * Calculates the total price of the sale, including VAT.
     *
     * @return The total price of the sale.
     */
    public int calculateTotalPrice() {
        int totalPriceWithVAT = 0;
        for (ItemDTO item : saleItems) {
            if (item != null) {
                totalPriceWithVAT += item.getPrice();   /// HAR ÄNDRAT SÅ VAT INTE LÄGGS PÅ TOTALEN AV PRISET
            }
        }
        return totalPriceWithVAT;
    }

    /**
     * Calculates the change to be returned to the customer after the sale.
     *
     * @return The change to be returned to the customer.
     */
    public int calculateChange(int customerPaid, int totalPrice) {
        return payment.calculateChange(customerPaid, totalPrice);
    }

    /**
     * Generates a receipt for the sale.
     */
    public void createReceipt() {
      receipt.initiateReceipt(saleDTO);
    }

    /**
     * Retrieves the information about the items sold in the sale.
     *
     * @return A list of ItemDTO objects representing the sold items.
     */
    public SaleDTO retrieveSaleInfo() {
        return new SaleDTO (saleItems);
        // create saleDTO and return
    }
}
