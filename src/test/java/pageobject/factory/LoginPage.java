package pageobject.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(css = ".notice.errors")
    private WebElement noticeErrorLabel;

    @FindBy(css = ".notice.success")
    private WebElement noticeSuccessLabel;

    //private WebDriver driver;

    public void typeEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void typePassword(String password) {
        passwordInput.sendKeys(password);
    }

    public boolean errorMessageIsDisplayed() {
        return noticeErrorLabel.isDisplayed();
    }

    public boolean successMessageIsDisplayed() {
        return noticeSuccessLabel.isDisplayed();
    }

    public String getErrorMessageText() {
        return noticeErrorLabel.getText();
    }

    public String getSuccessMessageText() {
        return noticeSuccessLabel.getText();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void loginWithCredentials(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }



}
