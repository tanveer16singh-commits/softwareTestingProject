package com.demowebshop.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    @BeforeSuite
    public void setupSuite() {
        // Opens browser ONCE for the entire test suite
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterSuite
    public void tearDownSuite() {
        // Closes browser ONLY after all tests in the suite have finished
        if (driver != null) {
            driver.quit();
        }
    }
}