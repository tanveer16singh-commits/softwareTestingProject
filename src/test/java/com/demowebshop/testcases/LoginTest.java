package com.demowebshop.testcases;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.RegisterPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    String email = "demouser_smartflow@gmail.com";
    String password = "Password123";

    @Test(priority = 1, description = "Smart Login: Try Login -> Register if missing -> Login Successfully")
    public void testSmartLoginFlow() {
        driver.get("https://demowebshop.tricentis.com/login");

        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        loginPage.loginUser(email, password);

        if (!loginPage.isLogoutLinkVisible()) {
            System.out.println("User not found or login failed. Redirecting to Registration...");
            driver.get("https://demowebshop.tricentis.com/register");
            registerPage.registerUser("Demo", "User", email, password);

            driver.get("https://demowebshop.tricentis.com/login");
            loginPage.loginUser(email, password);
        }

        Assert.assertTrue(loginPage.isLogoutLinkVisible(), "Login flow failed after registration attempt!");
    }

    @Test(priority = 2, description = "Verify invalid credentials fail gracefully")
    public void testInvalidLogin() {
        // If we are currently logged in from the previous test, log out first!
        try {
            driver.findElement(By.className("ico-logout")).click();
        } catch (Exception e) {
            // Already logged out, proceed normally
        }

        driver.get("https://demowebshop.tricentis.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("invalid_user_9999@gmail.com", "WrongPassword");

        Assert.assertFalse(loginPage.isLogoutLinkVisible(), "Invalid login should not display logout link!");
    }
}