package pageobject.selenide;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Listeners;

import java.time.Duration;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

//@Listeners(ScreenshotListener.class)
public class TestBase {

    String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public void methodSetup() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.baseUrl = "https://litecart.stqa.ru/en/";
        Configuration.pageLoadTimeout = 5000;
        open("https://litecart.stqa.ru/en/");
    }
    @AfterMethod
    public void methodTeardown(){
        Selenide.closeWebDriver();
    }

}
