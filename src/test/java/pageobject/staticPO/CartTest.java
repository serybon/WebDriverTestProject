package pageobject.staticPO;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


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
