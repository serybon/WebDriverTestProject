//package pageobject.seleAllure;
//
//import com.codeborne.selenide.Condition;
//import io.qameta.allure.Step;
//import org.openqa.selenium.By;
//
//import static com.codeborne.selenide.Selenide.$;
//
//public class CartPage {
//
//
//    private static By purpleDuckLink = By.cssSelector("[alt='Purple Duck']");
//    private static By addToCartButton = By.cssSelector("[name='add_cart_product'][type='submit']");
//    private static By cartQuantityLabelLocator = By.cssSelector("span[class='quantity']");
//    private static By cartLink = By.cssSelector("[src='/includes/templates/default.catalog/images/cart.png']");
//    private static By emptyCartMessage = By.cssSelector("#checkout-cart-wrapper>p>em");
//
//    @Step("Click on the Purple Duck element with the link.")
//    public static void clickPurpleDuckLink() {
//        $(purpleDuckLink).click();
//    }
//
//    @Step("Click on the add to cart button.")
//    public static void clickAddToCartButton() {
//        $(addToCartButton).click();
//    }
//
//    @Step("Validates that quantity matches expectation.")
//    public static void validateAddOnePurpleDuckToCart(String expectedText) {
//        $(cartQuantityLabelLocator).shouldHave(Condition.text(expectedText));
//    }
//
//    @Step("click on cart to enter it.")
//    public static void clickCart() {
//        $(cartLink).click();
//    }
//
//    @Step("Validates that empty cart message matches expectation")
//    public static void validateEmptyCartMessageText(String expectedText) {
//        $(emptyCartMessage).shouldHave(Condition.text(expectedText));
//    }
//}
