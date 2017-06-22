package framework.cars.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by d.korobkin on 6/20/17.
 */
public class ComboBox extends BaseElement {

    WebElement cmbSelect;
    WebElement cmbDrDown;

    public ComboBox(By bySelect, By byDrDown) {
        this.cmbSelect = findElement(bySelect);
        this.cmbDrDown = findElement(byDrDown);
    }

    public ComboBox(){
        super();
    }

    @Override
    public void click() {
        Actions actions = new Actions(super.getDriver());
        actions.moveToElement(cmbSelect).build().perform();
        cmbSelect.click();
        cmbSelect.click();
    }

    @Override
    public String getText() {
        return cmbSelect.getText();
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
        return cmbSelect.getAttribute(str);
    }

    public void dropComboBox(){
        Actions actions = new Actions(super.getDriver());
        actions.moveToElement(cmbDrDown).build().perform();
        cmbDrDown.click();
        cmbDrDown.click();
        actions.moveToElement(cmbSelect).build().perform();
        cmbSelect.click();
    }

    @Override
    public WebElement findElement(By locator) {
        return super.findElement(locator);
    }

    public static List<WebElement> findElements(String by){
        return findElements(by);
    }
}
