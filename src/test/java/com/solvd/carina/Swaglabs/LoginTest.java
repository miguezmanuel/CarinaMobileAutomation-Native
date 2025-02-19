package com.solvd.carina.Swaglabs;

import com.solvd.carina.android.pages.LoginPage;
import com.solvd.carina.android.pages.MenuPage;
import com.solvd.carina.android.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class LoginTest implements IAbstractTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        loginPage.open();
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(productsPage.isPageTitlePresent(), "Products page is not displayed after login.");
    }

    @Test
    public void failedLoginTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        loginPage.typeUsername("wrong_user");
        loginPage.typePassword("wrong_password");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorMessagePresent(), "Error message should be displayed for invalid login.");
    }

    @Test
    public void lockedOutUserTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        loginPage.typeUsername("locked_out_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorMessagePresent(), "Locked-out user error message was not shown.");
    }

    @Test
    public void emptyFieldsTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorMessagePresent(), "Error message was not shown when trying to log in with empty fields.");
    }

    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        MenuPage menuPage = new MenuPage(getDriver());

        loginPage.open();
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(productsPage.isPageTitlePresent(), "Products page is not displayed after login.");

        productsPage.getHeaderMenuComponent().clickOnMenuButton();
        Assert.assertTrue(menuPage.isAllItemsButtonPresent(), "Menu did not open correctly.");

        menuPage.clickOnLogoutButton();
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "User was not redirected to login screen after logout.");
    }
}