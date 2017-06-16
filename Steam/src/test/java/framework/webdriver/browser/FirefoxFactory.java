package framework.webdriver.browser;

import framework.steam.services.GeneralFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxFactory extends BrowserFactory{
    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver();
    }

    private static final String GECKO_DRIVER_NAME = "webdriver.gecko.driver";
    private static final String DRIVER_LOCATION_KEY_LIN = "driver_firefox_location_lin";
    private static final String DRIVER_LOCATION_KEY_WIN = "driver_firefox_location_win";
    private static FirefoxFactory instance = null;
    private static FirefoxDriver driver;

    public static WebDriver getInstance() {
        if (instance == null)
            instance = new FirefoxFactory();
        if (driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    private FirefoxFactory() {
        GeneralFunctions generalFunctions = new GeneralFunctions();
        String osType = System.getProperty("os.name").toLowerCase();
        if(osType.indexOf( "win" ) >= 0){
            System.setProperty(GECKO_DRIVER_NAME, generalFunctions.readProperties("config.properties").getProperty(DRIVER_LOCATION_KEY_WIN));
        }
        else if(osType.indexOf( "nix") >=0 || osType.indexOf( "nux") >=0) {
            System.setProperty(GECKO_DRIVER_NAME, generalFunctions.readProperties("config.properties").getProperty(DRIVER_LOCATION_KEY_LIN));
        }
    }
}



