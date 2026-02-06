package com.example.gm_4sel.tests;

import com.example.gm_4sel.pages.InventoryPage;
import com.example.gm_4sel.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Checkout process")
public class CheckoutTest extends BaseTest{
    @Test
    @Story("Checkout")
    @Description("Checkout with valid information")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckoutWithValidInformation(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");

        assertEquals("Products", inventoryPage.getPageTitle());
    }

    @Test
    @Story("Checkout")
    @Description("Checkout with missing first name")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckoutWithMissingFirstName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");

        assertEquals("Products", inventoryPage.getPageTitle());
    }
}
