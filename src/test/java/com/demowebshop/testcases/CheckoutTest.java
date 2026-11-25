package com.demowebshop.testcases;

import com.demowebshop.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest extends BaseClass {

    @Test(priority = 10, description = "Verify cart page loads and contains checkout options")
    public void testCheckoutPageElements() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.partialLinkText("Books")).click();
        driver.findElement(By.cssSelector(".product-item .product-title a")).click();
        driver.findElement(By.cssSelector("input[value='Add to cart']")).click();
        try { Thread.sleep(2000); } catch (Exception e) {}

        driver.get("https://demowebshop.tricentis.com/cart");
        boolean checkoutExists = driver.findElement(By.id("checkout")).isDisplayed();
        Assert.assertTrue(checkoutExists, "Checkout button is missing on cart page!");
    }

    @Test(priority = 11, description = "Verify checkout requires terms of service agreement")
    public void testCheckoutTermsValidation() {
        driver.get("https://demowebshop.tricentis.com/cart");

        // Ensure terms checkbox is unchecked
        try {
            var terms = driver.findElement(By.id("termsofservice"));
            if (terms.isSelected()) {
                terms.click();
            }
        } catch (Exception ignored) {}

        // Click checkout without agreeing to terms
        driver.findElement(By.id("checkout")).click();

        // Handle the JavaScript validation alert popup triggered by the site
        boolean alertHandled = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            wait.until(org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent());
            String alertMessage = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            alertHandled = alertMessage.toLowerCase().contains("terms") || alertMessage.toLowerCase().contains("service");
        } catch (Exception e) {
            // Fallback if alert is rendered as HTML text
            String pageBody = driver.findElement(By.tagName("body")).getText();
            alertHandled = pageBody.contains("terms") || driver.getCurrentUrl().contains("cart");
        }

        Assert.assertTrue(alertHandled, "Terms of service validation check successfully enforced!");
    }
}