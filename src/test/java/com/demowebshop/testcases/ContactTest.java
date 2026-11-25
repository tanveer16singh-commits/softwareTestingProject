package com.demowebshop.testcases;

import com.demowebshop.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseClass {

    @Test(priority = 12, description = "Verify Contact Us page loads successfully")
    public void testContactUsPage() {
        driver.get("https://demowebshop.tricentis.com/");

        // Click the Contact Us link in the footer
        driver.findElement(By.partialLinkText("Contact us")).click();

        // Verify the URL and page header
        boolean isContactPage = driver.getCurrentUrl().contains("contactus") &&
                driver.findElement(By.cssSelector(".page-title h1")).isDisplayed();

        Assert.assertTrue(isContactPage, "Failed to load Contact Us page!");
    }
}