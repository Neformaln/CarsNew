package framework.cars.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by d.korobkin on 6/20/17.
 */
public class CheckBox extends BaseElement {

    WebElement checkBox;

    public CheckBox(By by) {
        this.checkBox = findElement(by);
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

    }

    @Override
    public String getAttribute(String str) {
        return null;
    }

    public void check(){
        checkBox.click();
    }

}