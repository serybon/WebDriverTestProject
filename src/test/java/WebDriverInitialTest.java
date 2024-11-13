import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;


public class WebDriverInitialTest {
    @Test
    public void startBrowserTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.quit();
    }

    @Test
    public void findNinthLinkTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println(allLinks.size());
        allLinks.get(9).click();
    }

    @Test
    public void categorySubcategoryClickTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement categoryRubberDucks = driver.findElement(By.xpath("//nav[@class='twelve-eighty']//" +
                "a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(categoryRubberDucks).perform();
        //wait(1000);
        WebElement categorySubcategory = driver.findElement(By.xpath("//li[@class='category-2']//" +
                "a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/'] "));
        //wait(1000);
        categorySubcategory.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Subcategory | My Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.quit();
    }

    @Test
    public void jsAlertButtonTest() {
        SoftAssert softAssert = new SoftAssert();
        String expectedAlertText = "I am a JS Alert";
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlertButton = driver.findElement(By.cssSelector("[onclick = 'jsAlert()']"));
        jsAlertButton.click();
        Alert alert = driver.switchTo().alert();
        softAssert.assertEquals(alert.getText(), expectedAlertText);
        alert.accept();
        softAssert.assertAll();
        driver.quit();
    }

    @Test
    public void jsAlertConfirmTest() {
        SoftAssert softAssert = new SoftAssert();
        String expectedConfirmResult = "You clicked: Ok";
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirmButton = driver.findElement(By.cssSelector("[onclick = 'jsConfirm()']"));
        jsConfirmButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        softAssert.assertEquals(driver.findElement(By.id("result")).getText(), expectedConfirmResult);
        softAssert.assertAll();
        driver.quit();
    }

    @Test
    public void setJsPromptButtonTest() {
        SoftAssert softAssert = new SoftAssert();
        String expectedText = "You entered: Hello world!";
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPromptButton = driver.findElement(By.cssSelector("[onclick = 'jsPrompt()']"));
        jsPromptButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello world!");
        alert.accept();
        softAssert.assertEquals(driver.findElement(By.id("result")).getText(), expectedText);
        softAssert.assertAll();
        driver.quit();
    }

    @Test
    public void vfsTest() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String login = "bnds1988@gmail.com";
        String password = "1620873oipVfs!";
        driver.get("https://visa.vfsglobal.com/BLR/en/HUN/login");
        WebElement loginInput = driver.findElement(By.id("email"));
        loginInput.sendKeys(login);
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToLocation(300,420)
                .build();
    }

    @Test
    public void selectTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement selectElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(selectElement);
        dropdown.selectByIndex(2);
    }

    @Test
    public void inputUnregisteredUserloginTest() throws InterruptedException {
        String login = "katta@tut.by";
        String password = "123123";

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement loginInput = driver.findElement(By.cssSelector("input[type='text']"));
        loginInput.sendKeys(login);
        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.cssSelector("button[value='Login']"));
        Thread.sleep(4000);
        loginButton.click();

    }

}

