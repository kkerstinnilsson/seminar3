package se.kth.iv1350.pointofsale.model;

/**
 * Represents the payment process for a sale.
 */
public class Payment {

    /**
     * Creates a new instance of the Payment class.
     */
    public Payment() {
    }

    /**
     * Calculates the change to be returned to the customer.
     *
     * @param paidAmount The amount paid by the customer.
     * @param totalPrice The total price of the sale.
     * @return The change to be returned to the customer.
     */
    public int calculateChange(int paidAmount, int totalPrice) {
        return paidAmount - totalPrice;
    }
}
