package com.example.gm_4sel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private final By cartItem = By.cssSelector("div[data-test='inventory-item']");
    private final By continueShoppingButton = By.cssSelector("button[data-test='continue-shopping']");
    private final By checkoutButton = By.cssSelector("button[data-test='checkout']");


    public boolean isDisplayed() {
        return getCurrentUrl().equals("https://www.saucedemo.com/cart.html");
    }

    public Integer getItemCount() {
        List<WebElement> items = driver.findElements(cartItem);
        return items.size();
    }

    public CheckoutPage clickCheckout() {
        click(checkoutButton);
        return new CheckoutPage(this.driver);
    }

    public InventoryPage clickContinueShopping() {
        click(continueShoppingButton);
        return new InventoryPage(this.driver);
    }
}
