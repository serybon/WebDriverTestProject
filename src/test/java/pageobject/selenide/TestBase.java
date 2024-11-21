package pageobject.selenide;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import java.time.Duration;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public void methodSetup() {
        String browser = System.getProperty("browser", "chrome");

        Configuration.browser = browser;
        Configuration.pageLoadTimeout = 5000;
        open(baseUrl);
    }
}
