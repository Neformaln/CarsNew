package framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

/**
 * Created by d.korobkin on 6/14/17.
 */
public class BaseEntity {

    private static WebDriver driver;

    public BaseEntity() {
    }

    public BaseEntity(WebDriver driver1) {
        driver = driver1;
    }

    public  WebDriver getDriver() {
        return driver;
    }

    public void assertTrue(boolean isTrue){
        Assert.assertTrue(isTrue);
    }


}

