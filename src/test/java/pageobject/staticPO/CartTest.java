package pageobject.staticPO;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends TestBase {

    @Test
    public void checkEmptyCartTest() {
        CartPage.clickCart(driver);
        Assert.assertEquals(CartPage.getEmptyCartMessageText(driver), "There are no items in your cart.");

    }

    @Test
    public void addOnePurpleDuckToCart() {
        CartPage.clickPurpleDuckLink(driver);
        CartPage.clickAddToCartButton(driver);
        CartPage.waitForTextToBe(driver, "1");
        Assert.assertEquals(CartPage.getTextFromCartQuantityLabel(driver), "1");
    }
}
