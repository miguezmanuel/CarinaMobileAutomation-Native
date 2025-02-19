package com.solvd.carina.ios.components;

import com.solvd.carina.common.components.HeaderComponentBase;
import com.solvd.carina.common.pages.CartPageBase;
import com.solvd.carina.common.pages.MenuPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class iOSHeaderComponent extends HeaderComponentBase {

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    public iOSHeaderComponent(WebDriver driver) {
        super(driver);
    }

    public iOSHeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageBase clickOnCartButton() {
        cartButton.click();
        return initPage(driver, CartPageBase.class);
    }

    @Override
    public void clickOnMenuButton() {
        menuButton.click();
    }
}
