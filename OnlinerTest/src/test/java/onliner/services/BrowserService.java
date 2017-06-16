package onliner.services;

import org.openqa.selenium.WebDriver;

/**
 * Created by User on 09.06.2017.
 */
public abstract class BrowserService {

    public abstract WebDriver getDriver();

    public static BrowserService getFactory(String type) {
        switch (type) {
            case "chrome": {
                return ChromeService.getInstance();
            }
            case "firefox": {
                return FirefoxService.getInstance();
            }
        }
        throw new RuntimeException();
    }
}
