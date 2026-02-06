package com.example.gm_4sel.tests;

import com.example.gm_4sel.pages.InventoryPage;
import com.example.gm_4sel.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Inventory management")
public class InventoryTest extends BaseTest{
    @Test
    @Story("Inventory access")
    @Description("Inventory Page is displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void testInventoryPageDisplayed(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");

        assertEquals("Products", inventoryPage.getPageTitle());
    }
    @Test
    @Story("Inventory access")
    @Description("Inventory Page is displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddProductToCart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");
        inventoryPage.addBackpackToCart();

        assertEquals(1, inventoryPage.getCartItemCount());
    }
}
