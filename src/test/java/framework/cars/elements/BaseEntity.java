package framework.cars.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by d.korobkin on 6/20/17.
 */
public class BaseEntity {
    private static WebDriver driver;
    public static Logger logger = Logger.getLogger(BaseEntity.class);

    public BaseEntity() {
    }

    public BaseEntity(WebDriver driver1) {
        driver = driver1;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void assertTrue(boolean isTrue) {
        Assert.assertTrue(isTrue);
    }
}