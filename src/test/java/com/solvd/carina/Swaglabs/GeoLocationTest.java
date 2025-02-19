package com.solvd.carina.Swaglabs;

import com.solvd.carina.android.pages.LoginPage;
import com.solvd.carina.android.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class GeoLocationTest implements IAbstractTest {

    @Test
    public void geolocationTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        MenuPage menuPage = new MenuPage(getDriver());

        loginPage.open();
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        menuPage.clickGeoLocationButton();

        Assert.assertTrue(menuPage.isGeoLocationDisplayed(), "Geolocation feature did not work.");
    }
}
