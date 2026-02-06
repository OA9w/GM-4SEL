package com.example.gm_4sel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Integer.parseInt;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    private final By invetoryTitle = By.cssSelector("span[class='title']");
    private final By addBackpackButton = By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']");
    private final By cartItemBadge = By.cssSelector("span[data-test='shopping-cart-badge']");
    private final By cartButton = By.cssSelector("a[data-test='shopping-cart-link']");

    public boolean isDisplayed() {
        return getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    public String getPageTitle() {
        return getText(invetoryTitle);
    }
    public InventoryPage addBackpackToCart() {
        click(addBackpackButton);
        return this;
    }
    public Integer getCartItemCount() {
        return parseInt(getText(cartItemBadge));
    }

    public CartPage clickCartIcon() {
        click(cartButton);
        return new CartPage(this.driver);
    }
}
