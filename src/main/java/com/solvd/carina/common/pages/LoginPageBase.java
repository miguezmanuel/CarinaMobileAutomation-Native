package com.solvd.carina.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeUsername (String username);

    public abstract void typePassword (String password);

    public abstract void clickLoginButton ();

    public abstract boolean isErrorMessagePresent ();
}
