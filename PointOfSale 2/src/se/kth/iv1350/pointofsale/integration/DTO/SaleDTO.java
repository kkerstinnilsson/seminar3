package se.kth.iv1350.pointofsale.integration.DTO;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a data transfer object (DTO) for a sale, containing information about sold items.
 */
public class SaleDTO {
    private List<ItemDTO> soldItems;

    /**
     * Constructs a new SaleDTO object with an empty list of sold items.
     */
    public SaleDTO() {
        this.soldItems = new ArrayList<>();
    }

    public SaleDTO(List<ItemDTO> saleItems) {
        this.soldItems = new ArrayList<>();
        for (ItemDTO item : saleItems) {
            this.soldItems.add(new ItemDTO(item.getItemIdentifier(), item.getName(), item.getPrice(), item.getVAT(), item.getQuantity()));
        }
    } // kopia items hit 


    /**
     * Retrieves the list of sold items.
     *
     * @return The list of sold items.
     */
    public List<ItemDTO> getSoldItems() {
        return this.soldItems;
    }

    /**
     * Retrieves the VAT rate for the specified item.
     *
     * @param itemName The name of the item to retrieve the VAT rate for.
     * @return The VAT rate for the specified item.
     */
    public double getVATForItem(String itemName) {
        for (ItemDTO item : soldItems) {
            if (item.getName().equals(itemName)) {
                return item.getVAT();
            }
        }
        return 0.0;
    }

    /**
     * Retrieves the price for the specified item.
     *
     * @param itemName The name of the item to retrieve the price for.
     * @return The price for the specified item.
     */
    public double getPriceForItem(String itemName) {
        for (ItemDTO item : soldItems) {
            if (item.getName().equals(itemName)) {
                return item.getPrice();
            }
        }
        return 0.0;
    }
}