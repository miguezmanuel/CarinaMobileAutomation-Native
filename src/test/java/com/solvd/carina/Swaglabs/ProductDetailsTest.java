package com.solvd.carina.Swaglabs;

import com.solvd.carina.android.pages.LoginPage;
import com.solvd.carina.android.pages.ProductsPage;
import com.solvd.carina.common.pages.ProductDetailsPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class ProductDetailsTest implements IAbstractTest {

    @Test
    public void sroductDetailsTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        loginPage.open();
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductDetailsPageBase detailsPage = productsPage.openProductDetails("Sauce Labs Backpack");

        Assert.assertTrue(detailsPage.isProductTitleDisplayed("Sauce Labs Backpack"), "Product details page not opened.");
    }
}
