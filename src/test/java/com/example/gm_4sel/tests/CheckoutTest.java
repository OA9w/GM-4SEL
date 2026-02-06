package com.example.gm_4sel.tests;

import com.example.gm_4sel.pages.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        inventoryPage.addBackpackToCart();

        CartPage cartPage = inventoryPage.clickCartIcon();

        CheckoutPage checkoutPage = cartPage.clickCheckout();
        checkoutPage.fillInformation("Jean","Pierre","63000");

        CheckoutOverviewPage checkoutOverviewPage =checkoutPage.clickContinue();

        assertTrue(checkoutOverviewPage.isDisplayed());
    }

    @Test
    @Story("Checkout")
    @Description("Checkout with missing first name")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckoutWithMissingFirstName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");
        inventoryPage.addBackpackToCart();

        CartPage cartPage = inventoryPage.clickCartIcon();

        CheckoutPage checkoutPage = cartPage.clickCheckout();
        checkoutPage.fillInformation("","Pierre","63000");
        checkoutPage.clickContinue();

        assertNotSame("", checkoutPage.getErrorMessage());
    }
}
