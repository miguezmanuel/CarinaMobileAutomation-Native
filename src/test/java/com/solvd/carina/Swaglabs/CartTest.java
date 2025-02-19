package com.solvd.carina.Swaglabs;
import com.solvd.carina.android.pages.CartPage;
import com.solvd.carina.android.pages.LoginPage;
import com.solvd.carina.android.pages.ProductsPage;
import com.solvd.carina.common.pages.CartPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class CartTest implements IAbstractTest {

    @Test
    public void addToCartTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        loginPage.open();
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.addItemToCart("Sauce Labs Backpack");
        CartPageBase cartPage = productsPage.openCart();

        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Backpack"), "Item was not added to the cart.");
    }

    @Test
    public void removeFromCartTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        loginPage.open();
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.addItemToCart("Sauce Labs Backpack");
        CartPageBase cartPage = productsPage.openCart();

        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Backpack"), "Item was not added to the cart.");

        cartPage.removeItemFromCart("Sauce Labs Backpack");
        Assert.assertFalse(cartPage.isItemInCart("Sauce Labs Backpack"), "Item was not removed from the cart.");
    }
}