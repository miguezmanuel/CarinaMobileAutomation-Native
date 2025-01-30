package com.solvd.carina.Swaglabs;

import com.solvd.carina.android.pages.LoginPage;
import com.solvd.carina.android.pages.ProductsPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {

    @Test
    public void SuccessfulLoginTest () {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        loginPage.open();
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(productsPage.isPageTitlePresent(), "Products page title is not present");
    }

    @Test
    public void FailedLoginTest () {
        LoginPage loginPage = initPage(LoginPage.class);

        loginPage.typeUsername("wrong");
        loginPage.typePassword("wrong");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorMessagePresent(), "");
    }
}
