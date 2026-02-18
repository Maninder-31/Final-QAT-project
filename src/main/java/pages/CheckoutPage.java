
package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

    }

    // XPath locators

    By cartLink = By.xpath("//a[@class='shopping_cart_link']");

    By checkoutButton = By.xpath("//button[@id='checkout']");

    By firstNameField = By.xpath("//input[@id='first-name']");

    By lastNameField = By.xpath("//input[@id='last-name']");

    By postalCodeField = By.xpath("//input[@id='postal-code']");

    By continueButton = By.xpath("//input[@id='continue']");

    By finishButton = By.xpath("//button[@id='finish']");

    By completeMessage = By.xpath("//h2[@class='complete-header']");

    public void goToCart() {

        driver.findElement(cartLink).click();

    }

    public void clickCheckout() {

        driver.findElement(checkoutButton).click();

    }

    public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {

        driver.findElement(firstNameField).sendKeys(firstName);

        driver.findElement(lastNameField).sendKeys(lastName);

        driver.findElement(postalCodeField).sendKeys(postalCode);

        driver.findElement(continueButton).click();

    }

    public void finishCheckout() {

        driver.findElement(finishButton).click();

    }

    public String getCompleteMessage() {

        return driver.findElement(completeMessage).getText();

    }

}