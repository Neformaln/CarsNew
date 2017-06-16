package framework.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by d.korobkin on 6/15/17.
 */
public class Select extends BaseElements {

    WebElement select;

    public Select(By by) {
        this.select = findElement(by);
    }

    public Select(WebElement select){
        this.select = select;
    }

    @Override
    public void click() {
        Actions actions = new Actions(driver);
        actions.moveToElement(select).build().perform();
        select.click();
    }

    @Override
    public String getText() {
        return select.getText();
    }

    @Override
    public String getAttribute(String str) {
        return null;
    }

    @Override
    public void moveTo() {
        Actions actions = new Actions(driver);
        actions.moveToElement(select).build().perform();
    }
}
