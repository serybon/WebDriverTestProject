package pageobject.selenide;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {


    private static By purpleDuckLink = By.cssSelector("[alt='Purple Duck']");
    private static By addToCartButton = By.cssSelector("[name='add_cart_product'][type='submit']");
    private static By cartQuantityLabelLocator = By.cssSelector("span[class='quantity']");
    private static By cartLink = By.cssSelector("#cart a[class='content']");
    private static By emptyCartMessage = By.cssSelector("#checkout-cart-wrapper");


    public static void clickPurpleDuckLink() {
        $(purpleDuckLink).click();
    }

    public static void clickAddToCartButton() {
        $(addToCartButton).click();
    }

    public static void validateAddOnePurpleDuckToCart(String expectedText) {
        $(cartQuantityLabelLocator).shouldHave(text(expectedText));
    }

    public static void clickCart() {
        $(cartLink).click();
    }

    public static void validateEmptyCartMessageText(String expectedText) {
        $(emptyCartMessage).shouldHave(text(expectedText));
    }
}
