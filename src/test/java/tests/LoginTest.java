package tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {

    WebDriver driver;

    @BeforeMethod

    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }



@Test

public void validLoginTest() {

	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

	    driver.findElement(By.id("user-name")).sendKeys("standard_user");

	    driver.findElement(By.id("password")).sendKeys("secret_sauce");

	    driver.findElement(By.id("login-button")).click();

	}


@Test

public void invalidLoginTest() {

    driver.findElement(By.id("user-name")).sendKeys("standard_user");

    driver.findElement(By.id("password")).sendKeys("wrong_password");

    driver.findElement(By.id("login-button")).click();

    Assert.assertTrue(

        driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed()

    );

}





    @AfterMethod

    public void tearDown() {

        driver.quit();

    }

}

