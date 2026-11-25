package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    // Search or click first product from home page category
    @FindBy(css = ".product-item .product-title a")
    private WebElement firstProductLink;

    @FindBy(css = "input[value='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(className = "cart-qty")
    private WebElement cartQuantitySpan;

    @FindBy(className = "ico-cart")
    private WebElement shoppingCartLink;

    @FindBy(name = "removefromcart")
    private WebElement removeCheckbox;

    @FindBy(name = "updatecart")
    private WebElement updateCartButton;

    @FindBy(css = ".order-summary-content")
    private WebElement emptyCartMessage;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstProduct() {
        firstProductLink.click();
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public String getCartQuantityText() {
        return cartQuantitySpan.getText();
    }

    public void openCart() {
        shoppingCartLink.click();
    }

    public void removeItemFromCart() {
        removeCheckbox.click();
        updateCartButton.click();
    }

    public boolean isCartEmpty() {
        try {
            return emptyCartMessage.getText().contains("Your Shopping Cart is empty!");
        } catch (Exception e) {
            return false;
        }
    }
}