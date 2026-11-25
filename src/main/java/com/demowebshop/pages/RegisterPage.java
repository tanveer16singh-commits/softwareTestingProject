package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    @FindBy(id = "gender-male")
    private WebElement genderMaleRadio;

    @FindBy(id = "FirstName")
    private WebElement firstNameInput;

    @FindBy(id = "LastName")
    private WebElement lastNameInput;

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id = "register-button")
    private WebElement registerBtn;

    @FindBy(className = "result")
    private WebElement successResultText;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerUser(String fName, String lName, String email, String pwd) {
        genderMaleRadio.click();
        firstNameInput.sendKeys(fName);
        lastNameInput.sendKeys(lName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(pwd);
        confirmPasswordInput.sendKeys(pwd);
        registerBtn.click();
    }

    public String getSuccessMessage() {
        return successResultText.getText();
    }
}