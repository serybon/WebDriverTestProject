import com.sun.jdi.IntegerValue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Scanner;

public class RegistrationSignInTest {

    String email;
    String password;
    String firstName = "John";
    String lastName = "Johnson";
    String address = "150 5th Avenue";
    String postcode = "10128";
    String city = "New York";
    String phone = "+123456789";
    String password_confirmed = "b123123";


    public static void WriteToFile(String email, String password) {
        try {
            FileWriter fileWriter = new FileWriter("E:\\IntelliJ_source\\registrationCredentials.txt", true);
            fileWriter.append("\n Email: " + email + " Password: " + password);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Sorry, can't write to file. Full error message: " + e.getMessage());
        }
    }

    @Test
    public void newSuccessfulRegistrationTest() throws InterruptedException {
        String randomNumber = String.valueOf((int) (Math.floor(Math.random() * 10000)));
        email = "mail" + randomNumber + "@mail.com";
        System.out.println(randomNumber);
        password = "b123123";
        WriteToFile(email, password);

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement linkForNewCustomers = driver.findElement(By.cssSelector("#box-account-login " +
                "a[href='https://litecart.stqa.ru/en/create_account']"));
        linkForNewCustomers.click();
        Thread.sleep(2000);
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        WebElement addressInput = driver.findElement(By.name("address1"));
        WebElement postcodeInput = driver.findElement(By.name("postcode"));
        WebElement cityInput = driver.findElement(By.name("city"));
        WebElement selectCountry = driver.findElement(By.name("country_code"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement phoneInput = driver.findElement(By.name("phone"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement confirmedPasswordInput = driver.findElement(By.name("confirmed_password"));
        WebElement createAccountButton = driver.findElement(By.name("create_account"));
        WebElement newsLetterCheckbox = driver.findElement(By.name("newsletter"));

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        addressInput.sendKeys(address);
        postcodeInput.sendKeys(postcode);
        cityInput.sendKeys(city);
        Select dropDown = new Select(selectCountry);
        dropDown.selectByVisibleText("United States");
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);
        passwordInput.sendKeys(password);
        confirmedPasswordInput.sendKeys(password_confirmed);
        newsLetterCheckbox.click();
        createAccountButton.click();
        Thread.sleep(1000);
        // Явное ожидание изменения стиля элемента
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notices-wrapper")));


        WebElement noticesWrapper = driver.findElement(By.id("notices-wrapper"));
//
        Assert.assertEquals(noticesWrapper.getAttribute("style"), "");


        //WebElement noticeDiv = driver.findElement(By.id("notice-wrapper"));
//        WebElement boxAccount = driver.findElement(By.id("box-account"));
//        System.out.println(boxAccount.getText().f);

        //Assert.assertNotNull(Objects.isNull(boxAccount));

        //System.out.println(noticeDiv);
        //Assert.assertTrue(isElementVisible(driver,noticeDiv));
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@id='notices']/div/text()")), " Your customer account has been created.");
    }

    public Boolean isElementVisible1(WebDriver driver, WebElement webElement) {
        // Используем JavaScript для получения значения display
        String displayValue = (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].style.display;", webElement);
        System.out.println(displayValue);
        // Проверяем, является ли значение 'block'
        return "block".equals(displayValue);
    }
    // Метод для проверки видимости элемента
    public static boolean isElementVisible(WebDriver driver, WebElement element) {
        String displayValue = (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].style.display;", element);
        return "block".equals(displayValue);
    }
}

