package com.solvd.carina.android.pages;

import com.solvd.carina.common.pages.LoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.AccessibilityId;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement usernameField;
    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordField;
    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;
    @ExtendedFindBy(accessibilityId = "test-Error message")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeUsername(String username) {
        usernameField.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public void clickLoginButton() {
        loginButton.click();
    }

    @Override
    public boolean isErrorMessagePresent() {
        return errorMessage.isPresent();
    }

    @Override
    public boolean isLoginButtonPresent() {
        return loginButton.isPresent();
    }

}
