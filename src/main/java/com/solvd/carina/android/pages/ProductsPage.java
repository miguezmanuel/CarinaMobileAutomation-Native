package com.solvd.carina.android.pages;

import com.solvd.carina.common.components.HeaderComponentBase;
import com.solvd.carina.common.pages.ProductsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends ProductsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    private ExtendedWebElement pageTitle;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup")
    private HeaderComponentBase headerComponent;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponentBase getHeaderMenuComponent() {
        return null;
    }

    @Override
    public boolean isPageTitlePresent() {
        return pageTitle.isPresent();
    }
}
