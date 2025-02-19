package com.solvd.carina.ios.pages;

import com.solvd.carina.common.pages.ProductDetailsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends ProductDetailsPageBase {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sauce Labs Backpack']")
    private ExtendedWebElement productTitle;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductTitleDisplayed(String itemName) {
        return productTitle.format(itemName).isPresent();
    }
}
