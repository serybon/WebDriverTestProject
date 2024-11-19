package pageobject.staticPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest extends TestBase {

    @Test
    public void loginWithCorrectEmailAndWrongPassword() {
        SoftAssert softAssert = new SoftAssert();

        LoginPage.loginWithCredentials(driver, "mail5514@mail.com", "111111");
        softAssert.assertTrue(LoginPage.errorMessageIsDisplayed(driver), "Error message is not displayed.");
        softAssert.assertEquals(LoginPage.getErrorMessageText(driver), "Wrong password or the account is disabled, or does not exist");
        softAssert.assertAll();
    }

    @Test
    public void successfulRegistration() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage.clickLinkForNewCustomers(driver);
        LoginPage.inputDataInAllFields(driver, "Vasil", "Vasilevich", "Nemiga street 6-5",
                "220020", "Minsk", LoginPage.generateEmail(), "+123456789", "b123123",
                "b123123");
        LoginPage.selectCountryDropdown(driver, "Belarus");
        LoginPage.clickCreateAccountButton(driver);
        softAssert.assertTrue(LoginPage.successMessageIsDisplayed(driver), "Success message is not displayed.");
        softAssert.assertEquals(LoginPage.getSuccessMessageText(driver), "Your customer account has been created.");
        softAssert.assertAll();

    }

}
