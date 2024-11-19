package pageobject.staticPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {


    private static By purpleDuckLink = By.cssSelector("[alt='Purple Duck']");
    private static By addToCartButton = By.cssSelector("[name='add_cart_product'][type='submit']");
    public static By cartQuantityLabelLocator = By.cssSelector("span[class='quantity']");
    private static By cartLink = By.cssSelector("[src='/includes/templates/default.catalog/images/cart.png']");
    private static By emptyCartMessage = By.cssSelector("#checkout-cart-wrapper>p>em");


    public static void clickPurpleDuckLink(WebDriver driver) {
        driver.findElement(purpleDuckLink).click();
    }

    public static void clickAddToCartButton(WebDriver driver) {
        driver.findElement(addToCartButton).click();
    }

    public static void waitForTextToBe(WebDriver driver, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.textToBe(cartQuantityLabelLocator, expectedText));
    }

    public static String getTextFromCartQuantityLabel(WebDriver driver) {
        return driver.findElement(cartQuantityLabelLocator).getText();
    }

    public static void clickCart(WebDriver driver) {
        driver.findElement(cartLink).click();
    }

    public static String getEmptyCartMessageText(WebDriver driver) {
        return driver.findElement(emptyCartMessage).getText();
    }
}
