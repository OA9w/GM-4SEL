package com.example.gm_4sel.pages;

import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html");
    }

    public CheckoutPage fillInformation(String firstName, String lastName, String zipCode) {
        return this;
    }

    public CheckoutOverviewPage clickContinue(String firstName, String lastName, String zipCode) {
        return this;
    }
}
