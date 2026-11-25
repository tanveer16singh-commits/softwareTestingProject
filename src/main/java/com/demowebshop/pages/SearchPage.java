package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    @FindBy(id = "small-searchterms")
    private WebElement searchBox;

    @FindBy(css = "input.button-1.search-box-button")
    private WebElement searchButton;

    @FindBy(css = ".product-item")
    private List<WebElement> searchResults;

    @FindBy(css = ".result")
    private WebElement noResultMesssage;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }

    public boolean isNoResultDisplayed() {
        try {
            return noResultMesssage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}