package com.solvd.carina.android.pages;

import com.solvd.carina.common.components.HeaderComponentBase;
import com.solvd.carina.common.pages.CartPageBase;
import com.solvd.carina.common.pages.ProductDetailsPageBase;
import com.solvd.carina.common.pages.ProductsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductsPage extends ProductsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Sort']")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Price (low to high)']")
    private ExtendedWebElement sortByPriceLowToHigh;

    @FindBy(xpath = "//android.widget.TextView[contains(@content-desc, 'test-Price')]")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Sauce Labs')]")
    private ExtendedWebElement productItem;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "test-CART")
    private ExtendedWebElement cartButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addItemToCart(String itemName) {
        addToCartButton.click();
    }

    @Override
    public CartPageBase openCart() {
        cartButton.click();
        return initPage(driver, CartPageBase.class);
    }

    @Override
    public HeaderComponentBase getHeaderMenuComponent() {
        return null;
    }

    @Override
    public boolean isPageTitlePresent() {
        return pageTitle.isPresent();
    }

    @Override
    public void sortByPriceLowToHigh() {
        sortButton.click();
        sortByPriceLowToHigh.click();
    }

    @Override
    public boolean isSortedByPriceAscending() {
        if (productPrices.isEmpty()) {
            return false;
        }

        double previousPrice = 0.0;
        for (ExtendedWebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("$", "").trim();
            double currentPrice = Double.parseDouble(priceText);

            if (currentPrice < previousPrice) {
                return false;
            }
            previousPrice = currentPrice;
        }
        return true;
    }

    @Override
    public ProductDetailsPageBase openProductDetails(String itemName) {
        productItem.format(itemName).click();
        return initPage(getDriver(), ProductDetailsPageBase.class);
    }
}
