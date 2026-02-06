package com.example.gm_4sel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutOverviewPage extends BasePage{
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private final By totalPrice = By.cssSelector("div[data-test='total-label']");
    private final By cartItem = By.cssSelector("div[data-test='inventory-item']");
    private final By checkoutButton = By.cssSelector("button[data-test='finish']");


    public boolean isDisplayed() {
        return getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html");
    }

    public Integer getItemCount() {
        List<WebElement> items = driver.findElements(cartItem);
        return items.size();
    }

    public String getTotalPrice() {
        return getText(totalPrice);
    }

    public CheckoutCompletePage clickFinish() {
        click(checkoutButton);
        return new CheckoutCompletePage(this.driver);
    }
}
