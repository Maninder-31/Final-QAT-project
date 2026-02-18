
package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest {

    WebDriver driver;

    @BeforeMethod

    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        // Login before running checkout test

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        // Wait for inventory page to load

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));

    }

    @Test

    public void completeCheckoutTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Add product to cart

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Go to cart

        driver.findElement(By.className("shopping_cart_link")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));

        // Start checkout

        driver.findElement(By.id("checkout")).click();

        // Fill user information

        driver.findElement(By.id("first-name")).sendKeys("John");

        driver.findElement(By.id("last-name")).sendKeys("Doe");

        driver.findElement(By.id("postal-code")).sendKeys("12345");

        // Continue and finish checkout

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        // Verify success message

        String successMsg = wait.until(

                ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))

        ).getText();

        // Robust assertion

        Assert.assertTrue(successMsg.contains("Thank you"), "Checkout success message not found!");

    }

    @AfterMethod

    public void tearDown() {

        driver.quit();

    }

}


