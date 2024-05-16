package test.java.se.kth.iv1350.pointofsale.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import se.kth.iv1350.pointofsale.model.Payment;

public class PaymentTest {

    @Test
    public void testCalculateChange() {
        Payment payment = new Payment();
        int paidAmount = 100;
        int totalPrice = 50;
        int expectedChange = 50;
        int actualChange = payment.calculateChange(paidAmount, totalPrice);
        assertEquals(expectedChange, actualChange);
    }

    @Test
    public void testCalculateChangeWithZeroTotalPrice() {
        Payment payment = new Payment();
        int paidAmount = 100;
        int totalPrice = 0;
        int expectedChange = 100;
        int actualChange = payment.calculateChange(paidAmount, totalPrice);
        assertEquals(expectedChange, actualChange);
    }

    @Test
    public void testCalculateChangeWithZeroPaidAmount() {
        Payment payment = new Payment();
        int paidAmount = 0;
        int totalPrice = 50;
        int expectedChange = -50;
        int actualChange = payment.calculateChange(paidAmount, totalPrice);
        assertEquals(expectedChange, actualChange);
    }

}
