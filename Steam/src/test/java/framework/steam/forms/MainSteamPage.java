package framework.steam.forms;



import framework.steam.menus.Menu;
import framework.webdriver.browser.BrowserFactory;
import framework.webdriver.elements.Select;
import org.openqa.selenium.By;


import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by d.korobkin on 6/14/17.
 */
public class MainSteamPage extends BasePage {
    Menu menu;
    Properties locatorProperties;
    Select select;
    String gamesMenuLocatorKey = "gamesMenuLocator";
    String actionLocatorKey = "actionLocator";

    public MainSteamPage() {
        menu = new Menu();
    }

    public void moveToGamesMenu() throws UnsupportedEncodingException{
        BrowserFactory.waitImplicitly();
        BrowserFactory.waitPageToLoad();
        select = new Select(By.xpath(locatorProperties.getProperty(gamesMenuLocatorKey)));
        select.moveTo();
    }

    public void clickOnActionSubmenu(String id) throws UnsupportedEncodingException {
        String locator = new String(locatorProperties.getProperty(actionLocatorKey).getBytes("ISO-8859-1"), "UTF-8");
        select  = new Select(By.xpath(String.format(locator, id)));
        select.click();
    }
}
