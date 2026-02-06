package com.example.gm_4sel.tests;

import com.example.gm_4sel.pages.CartPage;
import com.example.gm_4sel.pages.InventoryPage;
import com.example.gm_4sel.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Shopping cart")
public class CartTest extends BaseTest{
    @Test
    @Story("Empty cart")
    @Description("Without adding product to the cart go in it")
    @Severity(SeverityLevel.NORMAL)
    public void testEmptyCart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");
        CartPage cartPage = inventoryPage.clickCartIcon();

        assertEquals(0, cartPage.getItemCount());
    }

    @Test
    @Story("1 item cart")
    @Description("Adding 1 product to the cart and go in it")
    @Severity(SeverityLevel.NORMAL)
    public void testCartWithOneProduct(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");
        inventoryPage.addBackpackToCart();
        CartPage cartPage = inventoryPage.clickCartIcon();

        assertEquals(1, cartPage.getItemCount());
    }

}
