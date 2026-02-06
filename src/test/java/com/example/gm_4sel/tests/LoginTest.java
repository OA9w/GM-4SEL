package com.example.gm_4sel.tests;

import com.example.gm_4sel.pages.InventoryPage;
import com.example.gm_4sel.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Login functionality")
public class LoginTest extends BaseTest{

    @Test
    @Story("Login test")
    @Description("Login test with valid credential")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");


        assertTrue(inventoryPage.isDisplayed(), "La page Inventory ne s'affiche pas correctement.");
    }

    @Test
    @Story("Login locked")
    @Description("Try to login with locked user")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithLockedUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        assertTrue(loginPage.getErrorMessage().contains("locked out"),
                "Le message ne contient pas 'Thank you'. : " + loginPage.getErrorMessage());
    }

    @Test
    @Story("Login wrong password")
    @Description("Try to login with invalid password")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user","wrong_password");
        assertTrue(loginPage.isErrorDisplayed());
    }
    @Test
    @Story("Login without credentials")
    @Description("Try to login with no credential")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("","");
        assertTrue(loginPage.isErrorDisplayed());
    }
}
