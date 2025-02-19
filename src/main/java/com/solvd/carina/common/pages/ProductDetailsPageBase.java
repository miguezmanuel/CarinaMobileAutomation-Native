package com.solvd.carina.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailsPageBase extends AbstractPage {

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductTitleDisplayed(String itemName);
}
