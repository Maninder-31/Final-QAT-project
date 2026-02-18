


package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    // XPath locators

    By usernameField = By.xpath("//input[@id='user-name']");

    By passwordField = By.xpath("//input[@id='password']");

    By loginButton = By.xpath("//input[@id='login-button']");

    By errorMessage = By.xpath("//h3[@data-test='error']");

    public void enterUsername(String username) {

        driver.findElement(usernameField).sendKeys(username);

    }

    public void enterPassword(String password) {

        driver.findElement(passwordField).sendKeys(password);

    }

    public void clickLogin() {

        driver.findElement(loginButton).click();

    }

    public String getErrorMessage() {

        return driver.findElement(errorMessage).getText();

    }

    public void login(String username, String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

    }

}