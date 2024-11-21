package pageobject.selenide;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CatalogTest extends TestBase {

    @Test
    public void sortDucksByName() {
        SoftAssert softAssert = new SoftAssert();
        CatalogPage.clickLinkRubberDuckNavigationPanel();
        CatalogPage.clickSoftByNameButton();

        softAssert.assertEquals(CatalogPage.getTitleOfFirstItemFromCollection(), "Blue Duck");
        softAssert.assertEquals(CatalogPage.getTitleOfLastItemFromCollection(), "Yellow Duck");
        softAssert.assertAll();
    }
}
