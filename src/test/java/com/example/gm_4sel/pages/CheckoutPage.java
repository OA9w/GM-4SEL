package com.example.gm_4sel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameInput = By.cssSelector("input[data-test='firstName']");
    private final By lastNameInput = By.cssSelector("input[data-test='lastName']");
    private final By postalCodeInput = By.cssSelector("input[data-test='postalCode']");
    private final By continueInput = By.cssSelector("input[data-test='continue']");
    private final By errorText = By.cssSelector("h3[data-test='error']");


    public boolean isDisplayed() {
        return getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html");
    }

    public CheckoutPage fillInformation(String firstName, String lastName, String zipCode) {
        type(firstNameInput,firstName);
        type(lastNameInput,lastName);
        type(postalCodeInput,zipCode);
        return this;
    }

    public CheckoutOverviewPage clickContinue() {
        click(continueInput);
        return new CheckoutOverviewPage(this.driver);
    }

    public String getErrorMessage() {
        return getText(errorText);
    }
}
