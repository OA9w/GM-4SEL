package com.example.gm_4sel.tests;

import com.example.gm_4sel.pages.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Order completion")
public class CheckoutCompleteTest extends BaseTest{
    @Test
    @Story("Complete order life")
    @Description("Order completion, from login to final message")
    @Severity(SeverityLevel.CRITICAL)
    public void testCompleteOrderFlow(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");
        inventoryPage.addBackpackToCart();

        CartPage cartPage = inventoryPage.clickCartIcon();

        CheckoutPage checkoutPage = cartPage.clickCheckout();
        checkoutPage.fillInformation("Jean","Pierre","63000");

        CheckoutOverviewPage checkoutOverviewPage = checkoutPage.clickContinue();

        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinish();
        assertTrue(checkoutCompletePage.getConfirmationMessage().contains("Thank you"),
                "Le message ne contient pas 'Thank you'. : " + checkoutCompletePage.getConfirmationMessage());
    }
}
