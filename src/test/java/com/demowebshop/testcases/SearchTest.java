package com.demowebshop.testcases;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.SearchPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseClass {

    @Test(priority = 4, description = "Verify searching for a valid product returns results")
    public void testValidProductSearch() {
        driver.get("https://demowebshop.tricentis.com/");
        SearchPage searchPage = new SearchPage(driver);

        searchPage.searchProduct("Laptop");

        int resultsCount = searchPage.getSearchResultsCount();
        Assert.assertTrue(resultsCount > 0, "Search for valid product returned no results!");
    }

    @Test(priority = 5, description = "Verify searching for a non-existent product shows no results message")
    public void testInvalidProductSearch() {
        driver.get("https://demowebshop.tricentis.com/");
        SearchPage searchPage = new SearchPage(driver);

        searchPage.searchProduct("NonExistentItemXYZ123");

        Assert.assertTrue(searchPage.isNoResultDisplayed(), "No result warning message was not displayed!");
    }

    @Test(priority = 6, description = "Verify category navigation from top menu")
    public void testCategoryNavigation() {
        driver.get("https://demowebshop.tricentis.com/");

        // Click on Computers -> Desktops from top menu
        driver.findElement(By.partialLinkText("Computers")).click();
        driver.findElement(By.partialLinkText("Desktops")).click();

        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Desktops"), "Failed to navigate to Desktops category page!");
    }
}