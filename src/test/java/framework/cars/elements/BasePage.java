package framework.cars.elements;

import framework.GeneralFunctions;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Created by d.korobkin on 6/20/17.
 */
public class BasePage extends BaseEntity {
    private static final String MAIN_PROPERTY_PATH = "config.properties";
    private static final String LOCATOR_PROPERTY_PATH = "locators.properties";
    private static Properties properties;
    private static Properties locatorProperties;
    private static WebDriver driver;

    public BasePage() {
    }

    public BasePage(By titleLocator, String title) {

            }

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void maximiseWindow() {
        BrowserFactory.maximiseWindow();
    }

    public void navigate(String url) {
        BrowserFactory.navigateUrl(url);
    }

    public void exit() {
        BrowserFactory.exit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Properties initProperties() {
        GeneralFunctions generalFunctions = new GeneralFunctions();
        properties = generalFunctions.readProperties(MAIN_PROPERTY_PATH);
        return properties;
    }

    public Properties initLocatorProperties() {
        GeneralFunctions generalFunctions = new GeneralFunctions();
        locatorProperties = generalFunctions.readProperties(LOCATOR_PROPERTY_PATH);
        return locatorProperties;
    }

    public void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static Properties getProperties() {
        return properties;
    }

    public Properties getLocatorProperties() {
        return locatorProperties;
    }

    }