package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "ico-register")
    private WebElement registerLink;

    @FindBy(className = "ico-login")
    private WebElement loginLink;

    @FindBy(id = "small-searchterms")
    private WebElement searchBox;

    @FindBy(css = "input.button-1.search-box-button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegister() {
        registerLink.click();
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void searchProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }
}