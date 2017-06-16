package tests;

import framework.steam.forms.*;
import framework.steam.menus.Menu;
import framework.webdriver.BaseEntity;
import framework.webdriver.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

/**
 * Created by d.korobkin on 6/15/17.
 */
public class SteamTest {

    WebDriver driver;
    BaseEntity baseEntity;

    @BeforeTest
    public void setUp() throws Exception {
        BasePage basePage = new BasePage();
        Properties properties = basePage.initProperties();
        basePage.initLocatorProperties();
        String browser = properties.getProperty("browser");
        driver = BrowserFactory.getFactory(browser);
        String mainPage = properties.getProperty("main_page_url");
        basePage = new BasePage(driver);
        basePage.maximiseWindow();
        basePage.navigateToUrl(mainPage);
        baseEntity = new BaseEntity();
    }

    @Test
    public void startSteamTest() throws UnsupportedEncodingException {
        MainSteamPage mainSteamPage = new MainSteamPage();
        mainSteamPage.moveToGamesMenu();
        mainSteamPage.clickOnActionSubmenu(Menu.ACTION);

        ActionPage actionPage = new ActionPage();
        actionPage.clickOnSpecials();
        List<String> list = actionPage.getDiscount();

        DescriptionPage descriptionPage = new DescriptionPage();
        descriptionPage.chooseAgeIfExist();


        baseEntity.assertTrue(descriptionPage.isSimilarPriceDiscount(list));
        descriptionPage.clickOnInstall();

        InstallPage installPage = new InstallPage();
        baseEntity.assertTrue(installPage.isFullDownload());
    }

    @AfterTest
    public void exit() {
        BasePage basePage = new BasePage(driver);
        basePage.exit();
    }
}
