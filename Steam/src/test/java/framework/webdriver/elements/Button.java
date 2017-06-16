package framework.webdriver.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends BaseElements {
    WebElement button;

    public Button(WebElement button) {
        this.button = button;
    }

    public Button(By by){
        this.button = findElement(by);
    }

    @Override
    public void click() {
        button.click();
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return button.getAttribute(name);
    }

    @Override
    public void moveTo() {

    }
}
