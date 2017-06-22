package framework.cars.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by d.korobkin on 6/20/17.
 */
public class Button extends BaseElement {
    WebElement button;

    public Button(By by){
        this.button = findElement(by);
    }

    public Button(WebElement button){
        this.button = button;
    }

    @Override
    public void click() {

    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public void moveTo() {
        Actions actions = new Actions(super.getDriver());
        actions.moveToElement(button).build().perform();
    }

    @Override
    public String getAttribute(String str) {
        return null;
    }

    public void submit(){
        button.submit();
    }
}