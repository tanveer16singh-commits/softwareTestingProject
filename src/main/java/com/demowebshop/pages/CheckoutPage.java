package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "termsofservice")
    private WebElement termsCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = "input.button-1.new-address-next-step")
    private WebElement billingContinueButton;

    @FindBy(css = "input.button-1.shipping-method-next-step")
    private WebElement shippingContinueButton;

    @FindBy(css = "input.button-1.payment-method-next-step")
    private WebElement paymentMethodContinueButton;

    @FindBy(css = "input.button-1.payment-info-next-step")
    private WebElement paymentInfoContinueButton;

    @FindBy(css = "input.button-1.confirm-order-next-step")
    private WebElement confirmOrderButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void acceptTermsAndCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }
        checkoutButton.click();
    }

    public void proceedThroughCheckoutSteps() {
        // Step 1: Billing Address
        try {
            wait.until(ExpectedConditions.elementToBeClickable(billingContinueButton)).click();
        } catch (Exception e) {}

        // Step 2: Shipping Method
        try {
            WebElement shipRadio = driver.findElement(By.id("shippingoption_0"));
            if (shipRadio.isDisplayed() && !shipRadio.isSelected()) {
                shipRadio.click();
            }
            wait.until(ExpectedConditions.elementToBeClickable(shippingContinueButton)).click();
        } catch (Exception e) {}

        // Step 3: Payment Method
        try {
            WebElement payRadio = driver.findElement(By.id("paymentmethod_0"));
            if (payRadio.isDisplayed() && !payRadio.isSelected()) {
                payRadio.click();
            }
            wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueButton)).click();
        } catch (Exception e) {}

        // Step 4: Payment Information
        try {
            wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinueButton)).click();
        } catch (Exception e) {}

        // Step 5: Confirm Order (Using JavaScript Executor for absolute reliability)
        try {
            WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOf(confirmOrderButton));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", confirmBtn);
        } catch (Exception e) {
            // Fallback standard click
            try {
                confirmOrderButton.click();
            } catch (Exception ignored) {}
        }
    }
}