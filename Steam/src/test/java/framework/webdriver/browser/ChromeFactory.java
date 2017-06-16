package framework.webdriver.browser;

import framework.steam.services.GeneralFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeFactory extends BrowserFactory {

    private static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
    private static final String DRIVER_LOCATION_KEY_WIN = "driver_chrome_location_win";
    private static final String DRIVER_LOCATION_KEY_LIN = "driver_chrome_location_lin";
    private static ChromeFactory instance = null;
    private static ChromeDriver driver;

    public static WebDriver getInstance() {
        if (instance == null)
            instance = new ChromeFactory();
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    private ChromeFactory() {
        GeneralFunctions generalFunctions = new GeneralFunctions();
        String osType = System.getProperty("os.name").toLowerCase();
        if (osType.indexOf("win") >= 0) {
            System.setProperty(CHROME_DRIVER_NAME, generalFunctions.readProperties("config.properties").getProperty(DRIVER_LOCATION_KEY_WIN));
        } else if (osType.indexOf("nix") >= 0 || osType.indexOf("nux") >= 0) {
            System.setProperty(CHROME_DRIVER_NAME, generalFunctions.readProperties("config.properties").getProperty(DRIVER_LOCATION_KEY_LIN));
        }

    }

    @Override
    public ChromeDriver getDriver() {
        return new ChromeDriver();
    }
}
