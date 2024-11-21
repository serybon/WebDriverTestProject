package pageobject.selenide;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends TestBase {

    @Test
    public void checkEmptyCartTest() {
        CartPage.clickCart();
        CartPage.validateEmptyCartMessageText("There are no items in your cart.");
    }

    @Test
    public void addOnePurpleDuckToCart() {
        CartPage.clickPurpleDuckLink();
        CartPage.clickAddToCartButton();
        CartPage.validateAddOnePurpleDuckToCart("1");
    }
}
