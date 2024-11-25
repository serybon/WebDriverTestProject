//package pageobject.seleAllure;
//
//import com.codeborne.selenide.Configuration;
//import org.testng.annotations.BeforeMethod;
//
//import static com.codeborne.selenide.Selenide.open;
////@Listeners({ReportPortalTestNGListener.class})
//public class TestBase {
//
//    String baseUrl = "https://litecart.stqa.ru/en/";
//
//    @BeforeMethod
//    public void methodSetup() {
//        String browser = System.getProperty("browser", "chrome");
//
//        Configuration.browser = browser;
//        Configuration.pageLoadTimeout = 5000;
//        open(baseUrl);
//    }
//}
