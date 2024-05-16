package test.java.se.kth.iv1350.pointofsale.controller;


import se.kth.iv1350.pointofsale.controller.Controller;
import se.kth.iv1350.pointofsale.integration.DTO.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ControllerTest {
    private Controller pointOfSaleController;

    @BeforeEach
    public void setUp() {
        this.pointOfSaleController = new Controller();
        this.pointOfSaleController.newSale();
    }

    @AfterEach
    public void tearDown() {
        this.pointOfSaleController = null; 
    }

    @Test
    public void testRegisterItem() {
        String itemID = "987654";
        int quantity = 1;
        ItemDTO item = this.pointOfSaleController.registerItem(itemID, quantity);
        assertNotNull(item, "Item registration returned null");
        assertNotNull(item.getItemIdentifier(), "Item identifier is null");
    }
    
    

    @Test
    public void testGetTotalPrice() {
            this.pointOfSaleController.registerItem("987654", 2);
            int totalPrice = this.pointOfSaleController.getTotalPrice();
            assertEquals(1098, totalPrice, "Total price calculation is incorrect");
        }

    @Test
    public void testConcludeSale() {
        this.pointOfSaleController.registerItem("987654", 1);
        int payment = 1000;
        int change = this.pointOfSaleController.concludeSale(payment);
        assertEquals(451, change, "Change calculation is incorrect");
    }

    @Test
    public void testGenerateReceipt() {
        this.pointOfSaleController.generateReceipt();
    }

    @Test
    public void testSendSaleInfo() {
        this.pointOfSaleController.sendSaleInfo();
    }
}




