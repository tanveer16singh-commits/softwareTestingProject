package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(partialLinkText = "Computers")
    private WebElement computersMenu;

    @FindBy(partialLinkText = "Electronics")
    private WebElement electronicsMenu;

    @FindBy(partialLinkText = "Desktops")
    private WebElement desktopsSubCategory;

    @FindBy(css = ".page-title h1")
    private WebElement pageHeader;

    @FindBy(css = ".header-logo a")
    private WebElement headerLogo;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickComputers() {
        wait.until(ExpectedConditions.elementToBeClickable(computersMenu)).click();
    }

    public void clickElectronics() {
        wait.until(ExpectedConditions.elementToBeClickable(electronicsMenu)).click();
    }

    public void clickDesktopsSubCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(desktopsSubCategory)).click();
    }

    public String getPageHeaderText() {
        return wait.until(ExpectedConditions.visibilityOf(pageHeader)).getText();
    }

    public void clickHeaderLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(headerLogo)).click();
    }
}