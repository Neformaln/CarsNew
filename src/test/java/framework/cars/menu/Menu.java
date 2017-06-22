package framework.cars.menu;

import framework.cars.elements.Select;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.By;

/**
 * Created by User on 21.06.2017.
 */
public class Menu {
    private static String tabsLocator = "//span[@class='at-least-desktop-inline' and contains(text(),'%s')]";

    public enum MenuItem{
        SEARCH("Search Cars for Sale"),
        READ("Read Specs & Reviews"),
        FIND("Find Service Centers & Dealers");

        private String value;

        MenuItem(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Menu() {
    }

    public void navigateMenu(MenuItem concreteItem){
        BrowserFactory.waitPageToLoad();
        BrowserFactory.waitPageToLoad();
        new Select(By.xpath(String.format(tabsLocator,concreteItem.getValue()))).click();
    }
}