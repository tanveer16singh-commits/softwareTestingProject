package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(css = "input.button-1.login-button")
    private WebElement loginButton;

    @FindBy(className = "ico-logout")
    private WebElement logoutLink;

    @FindBy(css = ".message-error validation-summary-errors")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String email, String password) {
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isLogoutLinkVisible() {
        try {
            return logoutLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}