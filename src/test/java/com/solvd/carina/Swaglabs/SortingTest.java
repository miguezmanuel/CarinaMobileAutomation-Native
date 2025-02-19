package com.solvd.carina.Swaglabs;

import com.solvd.carina.android.pages.LoginPage;
import com.solvd.carina.android.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class SortingTest implements IAbstractTest {

    @Test
    public void sortingProductsTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        loginPage.open();
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.sortByPriceLowToHigh();

        Assert.assertTrue(productsPage.isSortedByPriceAscending(), "Products were not sorted correctly.");
    }
}
