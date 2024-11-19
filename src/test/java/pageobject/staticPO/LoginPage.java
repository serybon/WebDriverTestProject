package pageobject.staticPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.Select;

import java.io.FileWriter;
import java.io.IOException;

public class LoginPage extends TestBase {

    String email;

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By errorMessageLabel = By.cssSelector(".notice.errors");
    private static By successMessageLabel = By.cssSelector(".notice.success");


    //Registration locators
    private static By linkForNewCustomers = By.cssSelector("#box-account-login " +
            "a[href = 'https://litecart.stqa.ru/en/create_account']");
    private static By firstNameInput = By.name("firstname");
    private static By lastNameInput = By.name("lastname");
    private static By addressInput = By.name("address1");
    private static By postcodeInput = By.name("postcode");
    private static By cityInput = By.name("city");
    private static By selectCountryDropdown = By.name("country_code");
    private static By emailRegInput = By.cssSelector("input[type='email'][name='email']");
    private static By phoneInput = By.name("phone");
    private static By passwordRegInput = By.cssSelector("input[type='password'][name='password']");
    private static By confirmedPasswordInput = By.name("confirmed_password");
    private static By createAccountButton = By.name("create_account");
    private static By newsLetterCheckbox = By.name("newsletter");
    //

    //Registration methods
    public static void inputDataInAllFields(WebDriver driver, String firstName, String lastName, String address,
                                            String postcode, String city, String email, String phone, String password,
                                            String password_confirmed) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(postcodeInput).sendKeys(postcode);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(emailRegInput).sendKeys(email);
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(passwordRegInput).sendKeys(password);
        driver.findElement(confirmedPasswordInput).sendKeys(password_confirmed);
    }

    public static void selectCountryDropdown(WebDriver driver, String country) {
        ru.yandex.qatools.htmlelements.element.Select dropdown = new Select(driver.findElement(selectCountryDropdown));
        dropdown.selectByVisibleText(country);
    }

    //
    public static void typeEmail(WebDriver driver, String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public static void typePassword(WebDriver driver, String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public static boolean errorMessageIsDisplayed(WebDriver driver) {
        return driver.findElement(errorMessageLabel).isDisplayed();
    }

    public static String getErrorMessageText(WebDriver driver) {
        return driver.findElement(errorMessageLabel).getText();
    }

    public static boolean successMessageIsDisplayed(WebDriver driver) {
        return driver.findElement(successMessageLabel).isDisplayed();
    }

    public static String getSuccessMessageText(WebDriver driver) {
        return driver.findElement(successMessageLabel).getText();
    }

    public static void clickLoginButton(WebDriver driver) {
        driver.findElement(loginButton).click();
    }

    public static void clickLinkForNewCustomers(WebDriver driver) {
        driver.findElement(linkForNewCustomers).click();
    }

    public static void clickCreateAccountButton(WebDriver driver) {
        driver.findElement(createAccountButton).click();
    }

    public static void loginWithCredentials(WebDriver driver, String email, String password) {
        LoginPage.typeEmail(driver, email);
        LoginPage.typePassword(driver, password);
        LoginPage.clickLoginButton(driver);
    }

    public static void WriteToFile(String email, String password) {
        try {
            FileWriter fileWriter = new FileWriter("E:\\IntelliJ_source\\registrationCredentials.txt", true);
            fileWriter.append("\n Email: " + email + " Password: " + password);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Sorry, can't write to file. Full error message: " + e.getMessage());
        }
    }

    public static String generateEmail() {
        String randomNumber = String.valueOf((int) (Math.floor(Math.random() * 10000)));
        String newEmail = "mail" + randomNumber + "@mail.com";
        return newEmail;

    }

    public static String getEnteredEmail(WebDriver driver) {
        System.out.println(driver.findElement(emailRegInput).getText() + "ПОЧТА");
        return driver.findElement(emailRegInput).toString();
    }

    public static String getEnteredPassword(WebDriver driver) {
        System.out.println(driver.findElement(passwordRegInput).getText() + "ПАРОЛЬ");
        return (driver.findElement(passwordRegInput)).getText();
    }


}
