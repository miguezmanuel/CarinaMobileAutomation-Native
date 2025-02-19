package com.solvd.carina.android.components;

import com.solvd.carina.common.components.HeaderComponentBase;
import com.solvd.carina.common.pages.CartPageBase;
import com.solvd.carina.common.pages.MenuPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class AndroidHeaderComponent extends HeaderComponentBase {
    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(3)")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private ExtendedWebElement swaglabsTitle;

    public AndroidHeaderComponent(WebDriver driver) {
        super(driver);
    }

    public AndroidHeaderComponent(WebDriver driver, SearchContext searchContext) {
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
