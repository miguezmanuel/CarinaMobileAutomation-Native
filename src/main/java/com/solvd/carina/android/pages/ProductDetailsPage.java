package com.solvd.carina.android.pages;

import com.solvd.carina.common.pages.ProductDetailsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends ProductDetailsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Backpack']")
    private ExtendedWebElement productTitle;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductTitleDisplayed(String itemName) {
        return productTitle.format(itemName).isPresent();
    }
}
