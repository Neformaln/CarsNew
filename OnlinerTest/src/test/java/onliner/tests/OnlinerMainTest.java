package onliner.tests;

import onliner.forms.CategoriesPage;
import onliner.forms.LoginPage;
import onliner.forms.MainPage;

import onliner.services.BrowserService;
import onliner.services.OnlinerService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;



public class OnlinerMainTest {

    private static final Logger logger = Logger.getLogger(OnlinerMainTest.class);

    @Parameters({"login", "password"})
    @Test
    public void OnlinerRunTest(String login, String password) throws IOException {

        OnlinerService onlinerService = new OnlinerService();
        Properties properties = onlinerService.readProperties();
        String br = properties.getProperty("brouser_type");
        WebDriver driver= BrowserService.getFactory(br).getDriver();
        String mainPage = properties.getProperty("mainURL");

        MainPage start= new MainPage(driver);
        start.pageNavigateWindow(mainPage);
        Assert.assertEquals(start.getUrl(),mainPage);
        start.clickForEnter();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login, password);
        Assert.assertEquals(start.clickForExitIfExist(),true);
        start.clickForRandomCategories();

        CategoriesPage categoriesPage = new CategoriesPage(driver);
        Assert.assertEquals(categoriesPage.getCategoryName(), start.getTextRandomCategories());
        categoriesPage.returnOnStartPage();
        start.findAndSaveOpinions();
        start.logout();
        Assert.assertTrue(start.isEnterExist());

        start.closeBrowser();


    }

}
