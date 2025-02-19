package com.solvd.carina.android.pages;

import com.solvd.carina.common.pages.LoginPageBase;
import com.solvd.carina.common.pages.MenuPageBase;
import com.solvd.carina.common.pages.ProductsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class MenuPage extends MenuPageBase {

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    @ExtendedFindBy(accessibilityId = "test-GEO LOCATION")
    private ExtendedWebElement geoLocationButton;

    @ExtendedFindBy(accessibilityId = "test-GeoLocationMessage")
    private ExtendedWebElement geoLocationMessage;

    @ExtendedFindBy(accessibilityId = "test-ALL ITEMS")
    private ExtendedWebElement allItemsButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    @Override
    public void clickGeoLocationButton() {
        geoLocationButton.click();
    }

    @Override
    public boolean isGeoLocationDisplayed() {
        return geoLocationMessage.isPresent();
    }

    @Override
    public boolean isLogoutButtonPresent() {
        return logoutButton.isPresent();
    }


    public ProductsPageBase clickOnAllItemsButton() {
        allItemsButton.click();
        return initPage(driver, ProductsPageBase.class);
    }

    @Override
    public boolean isAllItemsButtonPresent() {
        return allItemsButton.isPresent();
    }
}
