package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");
    private By errorMessageLabel = By.cssSelector(".notice.errors");
    private By successMessageLabel = By.cssSelector(".notice.success");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public boolean errorMessageIsDisplayed() {
        return driver.findElement(errorMessageLabel).isDisplayed();
    }

    public boolean successMessageIsDisplayed() {
        return driver.findElement(successMessageLabel).isDisplayed();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessageLabel).getText();
    }

    public String getSuccessMessageText() {
        return driver.findElement(successMessageLabel).getText();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void loginWithCredentials(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }



}
