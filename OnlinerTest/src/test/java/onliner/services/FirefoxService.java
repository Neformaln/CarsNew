package onliner.services;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by User on 11.06.2017.
 */
public class FirefoxService extends BrowserService {

    private static final String GECKO_DRIVER_NAME = "webdriver.gecko.driver";

    private static final String DRIVER_LOCATION_KEY_LIN = "driver_firefox_location_lin";

    private static final String DRIVER_LOCATION_KEY_WIN = "driver_firefox_location_win";

    private static final FirefoxService instance = new FirefoxService();

    public static synchronized FirefoxService getInstance()
    {
        return instance;
    }

    private FirefoxService() {
        OnlinerService onlinerService = new OnlinerService();
        String osType = System.getProperty("os.name").toLowerCase();
        if(osType.indexOf( "win" ) >= 0){
            System.setProperty(GECKO_DRIVER_NAME, onlinerService.readProperties().getProperty(DRIVER_LOCATION_KEY_WIN));
        }
        else if(osType.indexOf( "nix") >=0 || osType.indexOf( "nux") >=0) {
            System.setProperty(GECKO_DRIVER_NAME, onlinerService.readProperties().getProperty(DRIVER_LOCATION_KEY_LIN));
        }

    }
    @Override
    public FirefoxDriver getDriver()
    {
        return new FirefoxDriver();
    }


}
