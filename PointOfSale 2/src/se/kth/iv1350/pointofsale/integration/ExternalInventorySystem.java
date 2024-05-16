package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.integration.DTO.ItemDTO;
import se.kth.iv1350.pointofsale.integration.DTO.SaleDTO;

import java.util.ArrayList;

/**
 * Represents the external inventory system of the point of sale system, responsible for managing inventory.
 */
public class ExternalInventorySystem {

    private final ArrayList<ItemDTO> items = new ArrayList<>();

    /**
     * Constructs a new ExternalInventorySystem object and initializes inventory with some items.
     */
    public ExternalInventorySystem() {
        items.add(new ItemDTO("987654", "AirPods Max", 549, 0.12f, 10));
        items.add(new ItemDTO("654321", "AirPods", 149, 0.25f, 11));
        items.add(new ItemDTO("246810", "Apple Watch SE", 249, 0.06f, 15));
    }

    /**
     * Retrieves an item from the inventory based on its identifier.
     *
     * @param itemID The identifier of the item to retrieve.
     * @return The ItemDTO object representing the retrieved item, or null if not found.
     */
    public ItemDTO retrieveItem(String itemID) {
        for (ItemDTO itemDTO : items) {
            if (itemDTO.getItemIdentifier().compareTo(itemID) == 0) {
                return itemDTO;
            }
        }
        return null;
    }

    /**
     * Processes sale information.
     *
     * @param saleItems The list of sold items containing sale information.
     */
    public void saleInformation(SaleDTO saleItems) {
        System.out.println("\nSale information processed successfully in the inventory system.");
    }

}
