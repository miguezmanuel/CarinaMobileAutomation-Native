package com.solvd.carina.ios.pages;

import com.solvd.carina.common.pages.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends CartPageBase {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sauce Labs Backpack']")
    private ExtendedWebElement cartItem;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='test-REMOVE']")
    private ExtendedWebElement removeItemButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isItemInCart(String itemName) {
        return cartItem.format(itemName).isPresent();
    }

    @Override
    public void removeItemFromCart(String itemName) {
        cartItem.format(itemName).click();
        removeItemButton.click();
    }
}
