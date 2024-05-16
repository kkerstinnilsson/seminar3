package test.java.se.kth.iv1350.pointofsale.integration;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pointofsale.integration.AccountingSystem;
import se.kth.iv1350.pointofsale.integration.DTO.ItemDTO;
import se.kth.iv1350.pointofsale.integration.DTO.SaleDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountingSystemTest {
    private AccountingSystem accountingSystem;

    @BeforeEach
    public void setUp() {
        accountingSystem = new AccountingSystem();
    }

    @Test
    public void testProcessSaleInformation() {
        List<ItemDTO> saleItems = new ArrayList<>();
        saleItems.add(new ItemDTO("123456", "Product 1", 100, 0.25f, 1));
        saleItems.add(new ItemDTO("654321", "Product 2", 200, 0.12f, 2));

        SaleDTO saleDTO = new SaleDTO(saleItems);
        accountingSystem.processSaleInformation(saleDTO); 
    }
}

