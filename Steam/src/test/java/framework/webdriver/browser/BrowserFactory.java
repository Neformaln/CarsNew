package framework.webdriver.browser;

import framework.steam.services.GeneralFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public abstract class BrowserFactory {

    private static final String MAIN_PROPERTY_PATH="config.properties";
    public abstract WebDriver getDriver();
    private static WebDriver driver;
    private static Properties properties;
    static  Long started;

    public static WebDriver getFactory(String type) throws Exception {
        switch (type) {
            case "Chrome": {
               driver = ChromeFactory.getInstance();
               initProperties();
               return driver;
            }
            case "Firefox": {
                driver = FirefoxFactory.getInstance();
                initProperties();
                return driver;
            }
            default:throw new Exception("browser not found");
        }

    }

       public static void initProperties(){
        GeneralFunctions generalFunctions = new GeneralFunctions();
        properties = generalFunctions.readProperties(MAIN_PROPERTY_PATH);
    }


    public static void waitWithIgnoring(){
        Wait<WebDriver> wait = new WebDriverWait(driver, getTimeForLoadElement())
                .ignoring(java.util.NoSuchElementException.class, ElementNotVisibleException.class);

    }

    public static void waitImplicitly(){
        driver.manage().timeouts().implicitlyWait(getTimeForLoadElement(), TimeUnit.SECONDS);
    }

    public static void waitElementExplicide(String locator){
        WebDriverWait wait = new WebDriverWait(driver, getTimeForLoadElement());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public static void waitElementsExplicide(String locator){
        WebDriverWait wait = new WebDriverWait(driver, getTimeForLoadElement());
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    public static void maximiseWindow(){
        driver.manage().window().maximize();
    }

    public static void navigateToUrl(String url){
        driver.navigate().to(url);
    }

    public static Long getTimeForLoadPage(){
        return Long.parseLong(properties.getProperty("timeoutJs"));

    }

    public static Long getTimeForLoadElement(){
        return Long.parseLong(properties.getProperty("timeout"));

    }

    public static void waitPageToLoad(){
        try {
            Thread.sleep(getTimeForLoadPage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void exit(){
        driver.close();
    }
}


