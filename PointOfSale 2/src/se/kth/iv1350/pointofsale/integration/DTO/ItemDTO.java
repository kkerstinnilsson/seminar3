package se.kth.iv1350.pointofsale.integration.DTO;

/**
 * Represents an item data transfer object (DTO) containing information about an item.
 */
public class ItemDTO {
    String itemIdentifier;
    String name;
    float price;
    int quantity;
    float VAT;

    /**
     * Constructs a new ItemDTO object with the specified parameters.
     *
     * @param itemIdentifier The unique identifier of the item.
     * @param name           The name of the item.
     * @param price          The price of the item.
     * @param d            The VAT rate for the item.
     * @param quantity       The quantity of the item.
     */
    public ItemDTO(String itemIdentifier, String name, float price, float d, int quantity){
        this.itemIdentifier = itemIdentifier;
        this.name = name;
        this.price = price;
        this.VAT = d;
        this.quantity = quantity;
    }

    public ItemDTO(String string, String string2, int i, String string3) {
        //TODO Auto-generated constructor stub
    }

    /**
     * Retrieves the item's unique identifier.
     *
     * @return The item's unique identifier.
     */
    public String getItemIdentifier() {
        return itemIdentifier;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the price of the item.
     *
     * @return The price of the item.
     */
    public float getPrice(){
        return price;
    }

    /**
     * Retrieves the VAT rate for the item.
     *
     * @return The VAT rate for the item.
     */
    public float getVAT() {
        return VAT;
    }

    /**
     * Retrieves the quantity of the item.
     *
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }

}
