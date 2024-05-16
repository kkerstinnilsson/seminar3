package test.java.se.kth.iv1350.pointofsale.model;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.pointofsale.integration.DTO.ItemDTO;
import se.kth.iv1350.pointofsale.integration.DTO.SaleDTO;
import se.kth.iv1350.pointofsale.model.Sale;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SaleTest {

    @Test
    public void testRecordSoldItem() {
        Sale sale = new Sale();
        ItemDTO item = new ItemDTO("123", "Product 1", 100, (float) 0.25, 1);
        int quantity = 2;

        sale.recordSoldItem(item, quantity);

        SaleDTO saleDTO = sale.retrieveSaleInfo();
        assertNotNull(saleDTO, "SaleDTO is null");
        List<ItemDTO> soldItems = saleDTO.getSoldItems();
        assertNotNull(soldItems, "List of sold items is null");
        assertEquals(2, soldItems.size(), "Incorrect number of sold items");
    }

    @Test
    public void testCalculateTotalPrice() {
        Sale sale = new Sale();
        ItemDTO item = new ItemDTO("123", "Product 1", 100, (float) 0.25, 1);
        int quantity = 2;
        sale.recordSoldItem(item, quantity);

        int totalPrice = sale.calculateTotalPrice();
        assertEquals(200, totalPrice, "Incorrect total price calculated");
    }

    @Test
    public void testCalculateChange() {
        Sale sale = new Sale();
        int customerPaid = 300;
        int totalPrice = 200;

        int change = sale.calculateChange(customerPaid, totalPrice);
        assertEquals(100, change, "Incorrect change calculated");
    }

    @Test
    public void testCreateReceipt() {
        Sale sale = new Sale();
        sale.createReceipt();
    }
}

