package com.example.gm_4sel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private final By orderCompleteTitle = By.cssSelector("div[data-test='complete-header']");
    public boolean isDisplayed() {
        return getCurrentUrl().equals("https://www.saucedemo.com/checkout-complete.html");
    }

    public String getConfirmationMessage() {
        return getText(orderCompleteTitle);
    }
}
