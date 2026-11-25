package com.demowebshop.testcases;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass {

    @Test
    public void verifyUserRegistration() {
        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        String uniqueEmail = "testuser" + System.currentTimeMillis() + "@gmail.com";

        registerPage.registerUser("John", "Doe", uniqueEmail, "TestPassword123");

        String actualMessage = registerPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, "Your registration completed", "Registration failed!");
    }
}