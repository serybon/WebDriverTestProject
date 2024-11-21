package pageobject.selenide;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {

    @Test
    public void loginWithCorrectEmailAndWrongPassword() {
        LoginPage.loginWithCredentials("mail5514@mail.com", "111111");
        LoginPage.validateErrorMessageIsDisplayed();
        LoginPage.validateErrorMessageText("Wrong password or the account is disabled, or does not exist");
    }

    @Test
    public void successfulRegistration() {
        LoginPage.clickLinkForNewCustomers();
        LoginPage.inputDataInAllFields("Vasil", "Vasilevich", "Nemiga street 6-5",
                "220020", "Minsk", LoginPage.generateEmail(), "+123456789", "b123123",
                "b123123");
        LoginPage.selectCountryDropdown("Belarus");
        LoginPage.clickCreateAccountButton();
        LoginPage.validateSuccessMessageIsDisplayed();
        LoginPage.validateSuccessMessageText("Your customer account has been created.");
    }

}
