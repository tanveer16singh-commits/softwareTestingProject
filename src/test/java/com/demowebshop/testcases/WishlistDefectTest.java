package com.demowebshop.testcases;

import com.demowebshop.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistDefectTest extends BaseClass {

    @Test(priority = 17, description = "DEFECT TEST: Verify wishlist button presence on book product page")
    public void testWishlistButtonMissingOnBookProduct() {
        // Navigate directly to a book item where wishlist functionality is missing/inconsistent
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.partialLinkText("Books")).click();

        // Open the first book item
        driver.findElement(By.cssSelector(".product-item .product-title a")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Attempt to locate the wishlist button on the item page
        WebElement wishlistButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.add-to-wishlist-button"))
        );

        Assert.assertTrue(wishlistButton.isDisplayed(), "Application Defect: Wishlist button is missing on this book product page!");
    }
}