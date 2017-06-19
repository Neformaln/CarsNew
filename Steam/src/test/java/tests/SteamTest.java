package tests;

import framework.steam.forms.*;
import framework.steam.menus.Menu;
import framework.webdriver.BaseEntity;
import framework.webdriver.BaseForm;
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
public class SteamTest{

    WebDriver driver;
    BaseEntity baseEntity;

    @BeforeTest
    public void setUp() throws Exception {
        BaseForm baseForm = new BaseForm();
        Properties properties = baseForm.initProperties();
        baseForm.initLocatorProperties();
        String browser = properties.getProperty("browser");
        driver = BrowserFactory.getDriver(browser);
        String mainPage = properties.getProperty("main_page_url");
        baseForm = new BaseForm(driver);
        baseForm.maximiseWindow();
        baseForm.navigate(mainPage);
        baseEntity = new BaseEntity();
    }

    @Test
    public void startTest() throws UnsupportedEncodingException {
        MainSteamPage mainSteamPage = new MainSteamPage();
        mainSteamPage.changeLanguage();
        mainSteamPage.moveToGamesMenu();
        mainSteamPage.clickOnActionSubmenu(Menu.ACTION);

        ActionForm actionForm = new ActionForm();
        actionForm.clickOnSpecials();
        List<String> list = actionForm.getDiscount();

        DescriptionForm descriptionForm = new DescriptionForm();
        descriptionForm.chooseAgeIfExist();

        baseEntity.assertTrue(descriptionForm.isSimilarPriceDiscount(list));
        descriptionForm.clickOnInstall();

        InstallForm installForm = new InstallForm();
        baseEntity.assertTrue(installForm.isFullDownload());
    }

    @AfterTest
    public void exit() {
        BaseForm baseForm = new BaseForm(driver);
        baseForm.exit();
    }
}
