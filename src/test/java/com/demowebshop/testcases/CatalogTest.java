package com.demowebshop.testcases;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.CatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseClass {

    @Test(priority = 13, description = "Verify navigation to Computers category")
    public void testComputersCategoryNavigation() {
        driver.get("https://demowebshop.tricentis.com/");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickComputers();

        String header = catalogPage.getPageHeaderText();
        Assert.assertTrue(header.equalsIgnoreCase("Computers"), "Failed to navigate to Computers category!");
    }

    @Test(priority = 14, description = "Verify navigation to Desktops sub-category")
    public void testDesktopsSubCategoryNavigation() {
        driver.get("https://demowebshop.tricentis.com/");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickComputers();
        catalogPage.clickDesktopsSubCategory();

        String header = catalogPage.getPageHeaderText();
        Assert.assertTrue(header.equalsIgnoreCase("Desktops"), "Failed to navigate to Desktops sub-category!");
    }

    @Test(priority = 15, description = "Verify navigation to Electronics category")
    public void testElectronicsCategoryNavigation() {
        driver.get("https://demowebshop.tricentis.com/");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickElectronics();

        String header = catalogPage.getPageHeaderText();
        Assert.assertTrue(header.equalsIgnoreCase("Electronics"), "Failed to navigate to Electronics category!");
    }

    @Test(priority = 16, description = "Verify clicking navbar logo navigates back to home page")
    public void testNavbarLogoNavigation() {
        // Go directly to a sub-page (like Contact Us)
        driver.get("https://demowebshop.tricentis.com/contactus");

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickHeaderLogo();

        String currentUrl = driver.getCurrentUrl();
        boolean isHome = currentUrl.equals("https://demowebshop.tricentis.com/") || currentUrl.equals("https://demowebshop.tricentis.com");

        Assert.assertTrue(isHome, "Failed to navigate back to Home page via navbar logo!");
    }
}