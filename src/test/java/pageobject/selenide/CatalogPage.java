package pageobject.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Attribute;
import com.codeborne.selenide.conditions.AttributeWithValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class CatalogPage {


    private static By linkRubberDucksNavigationPanel = By.cssSelector("#box-category-tree nav a");
    private static By sortByNameButton = By.cssSelector(".filter " +
            "a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name']");
    private static By ulItem = By.cssSelector("#box-category ul.listing-wrapper.products");
    private static By liItem = By.tagName("li");
    private static By linkItem = By.cssSelector("a.link");


    public static void clickLinkRubberDuckNavigationPanel() {
        $(linkRubberDucksNavigationPanel).click();
    }

    public static void clickSoftByNameButton() {
        $(sortByNameButton).click();
    }

    public static List<String> getListOfDucksInCatalog() {

        // Поиск элемента <ul> с классом 'listing-wrapper products'
        WebElement ulElement = $(ulItem);
        // Получение всех элементов <li> в списке
        List<WebElement> liElements = ulElement.findElements(liItem);
        // Список для хранения значений атрибута title
        List<String> titleList = new ArrayList<>();
        // Извлечение атрибута title из каждого элемента <li> и добавление в список
        for (WebElement li : liElements) {
            // Поиск элемента <a> с классом 'link' внутри <li>
            WebElement linkElement = li.findElement(linkItem);
            String titleValue = linkElement.getAttribute("title");
            titleList.add(titleValue);
        }
        return titleList;
    }

    public static ElementsCollection getCollectionSelenideElements() {
        SelenideElement ulElement = $(ulItem);
        ElementsCollection liElements = ulElement.findAll(liItem);
        return liElements;
    }
//        if(!liElements.isEmpty())
//
//    {
//        SelenideElement firstLi = liElements.first();
//
//        // Извлекаем элемент a внутри первого li и получаем атрибут title
//        String title = firstLi.find("a.link").getAttribute("title");
//
//        // Выводим значение атрибута title
//        System.out.println("Title первого элемента: " + title);
//    } else
//
//    {
//        System.out.println("Список не содержит элементов li.");
//    }
//
//}

    public static String getTitleOfFirstItemFromCollection() {
        SelenideElement firstLi = getCollectionSelenideElements().first();
        return firstLi.find(linkItem).getAttribute("title");

    }

    public static String getTitleOfLastItemFromCollection() {
        return getCollectionSelenideElements().last().findElement(linkItem).getAttribute("title");
    }

}
