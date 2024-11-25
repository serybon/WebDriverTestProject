//package pageobject.seleAllure;
//
//import io.qameta.allure.Description;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import java.util.Collections;
//import java.util.List;
//
//@Epic("Сatalog functionality")
//@Feature("Duck sorting")
//public class CatalogTest extends TestBase {
//
//    @Description("This method checks if the ducks are sorted correctly by name")
//    @Test
//    public void sortDucksByName() {
//        SoftAssert softAssert = new SoftAssert();
//        CatalogPage.clickLinkRubberDuckNavigationPanel();
//        CatalogPage.clickSortByNameButton();
//
//        softAssert.assertEquals(CatalogPage.getTitleOfFirstItemFromCollection(), "Blue Duck");
//        softAssert.assertEquals(CatalogPage.getTitleOfLastItemFromCollection(), "Yellow Duck");
//        softAssert.assertAll();
//    }
//
//    @Description("Method compares the list of products after clicking the button")
//    @Test
//    public void sortByNameFullComparison() {
//        CatalogPage.clickLinkRubberDuckNavigationPanel();
//        List<String> listBefore = CatalogPage.getListOfTitles();
//        Collections.sort(listBefore);
//        CatalogPage.clickSortByNameButton();
//        List<String> listAfterClickSortByNameButton = CatalogPage.getListOfTitles();
//        Assert.assertTrue(CatalogPage.CompareLists(listBefore, listAfterClickSortByNameButton));
//    }
//}
