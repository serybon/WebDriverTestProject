package pageobject.fluent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");
    private By errorMessageLabel = By.cssSelector(".notice.errors");
    private By successMessageLabel = By.cssSelector(".notice.success");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return  this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
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

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public ErrorPage loginWithIncorrectCredentials(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
        return new ErrorPage(driver);
    }



}
