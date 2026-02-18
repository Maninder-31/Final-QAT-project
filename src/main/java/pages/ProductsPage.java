

package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {

        this.driver = driver;

    }

    // XPath locators

    By firstProduct = By.xpath("(//button[text()='Add to cart'])[1]");

    By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");

    public void addFirstProductToCart() {

        driver.findElement(firstProduct).click();

    }

    public String getCartItemCount() {

        return driver.findElement(cartBadge).getText();

    }

}