package com.solvd.carina.common.pages;

import com.solvd.carina.common.components.HeaderComponentBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductsPageBase extends AbstractPage {

    public ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderComponentBase getHeaderMenuComponent();

    public abstract boolean isPageTitlePresent();

    public abstract void sortByPriceLowToHigh();

    public abstract boolean isSortedByPriceAscending();

    public abstract ProductDetailsPageBase openProductDetails(String itemName);

    public abstract void addItemToCart(String itemName);

    public abstract CartPageBase openCart();
}
