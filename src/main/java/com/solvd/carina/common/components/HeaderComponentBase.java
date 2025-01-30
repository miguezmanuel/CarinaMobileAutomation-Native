package com.solvd.carina.common.components;

import com.solvd.carina.common.pages.CartPageBase;
import com.solvd.carina.common.pages.MenuPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderComponentBase extends AbstractUIObject {

    public HeaderComponentBase(WebDriver driver) {
        super(driver);
    }

    public HeaderComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract CartPageBase clickOnCartButton();
    public abstract MenuPageBase clickOnMenuButton();
}
