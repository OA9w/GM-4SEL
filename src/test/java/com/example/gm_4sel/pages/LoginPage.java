package com.example.gm_4sel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginInput = By.cssSelector("input[placeholder='Username']");
    private final By passwordInput = By.cssSelector("input[placeholder='Password']");
    private final By buttonLoginInput = By.cssSelector("input[id='login-button']");


    public LoginPage open() {
        goTo(ROOT_URL);
        return this;
    }

    public InventoryPage login(String username, String password) {
        open();
        type(loginInput,username);
        type(passwordInput,username);
        click(buttonLoginInput);
        return new InventoryPage(this.driver);
    }

    public String getErrorMessage() {
        return ;
    }

    public Boolean isErrorDisplayed() {
        return ;
    }
}
