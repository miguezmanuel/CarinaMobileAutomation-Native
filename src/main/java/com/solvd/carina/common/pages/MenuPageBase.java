package com.solvd.carina.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends AbstractPage {

    public MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnLogoutButton();

    public abstract void clickGeoLocationButton();

    public abstract boolean isGeoLocationDisplayed();

    public abstract boolean isLogoutButtonPresent();
    public abstract boolean isAllItemsButtonPresent();
}
