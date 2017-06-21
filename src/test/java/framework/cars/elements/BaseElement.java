package framework.cars.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by d.korobkin on 6/20/17.
 */
public abstract class BaseElement extends BaseEntity {

    WebDriver driver;

    public BaseElement() {
    }

    public abstract void click();
    public abstract String getText();
    public abstract void moveTo();
    public abstract String getAttribute(String str);

    public static List<WebElement> findElements(String by) {
        return getDriver().findElements(By.xpath(by));
    }

    public WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }
}