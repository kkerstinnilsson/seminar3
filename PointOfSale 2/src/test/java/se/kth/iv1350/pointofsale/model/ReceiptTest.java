package test.java.se.kth.iv1350.pointofsale.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pointofsale.integration.DTO.SaleDTO;
import se.kth.iv1350.pointofsale.model.Receipt;

import java.time.LocalTime;

public class ReceiptTest {

    @Test
    public void testInitiateReceipt() {
        LocalTime timeOfSale = LocalTime.of(12, 30, 0); 
        Receipt receipt = new Receipt(timeOfSale);
        receipt.initiateReceipt(new SaleDTO());
        assertNotNull(receipt, "Receipt instance is null");
    }
}

