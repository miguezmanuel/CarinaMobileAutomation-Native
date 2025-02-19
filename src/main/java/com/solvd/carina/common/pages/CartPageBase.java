package com.solvd.carina.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isItemInCart(String itemName);

    public abstract void removeItemFromCart(String itemName);


}
