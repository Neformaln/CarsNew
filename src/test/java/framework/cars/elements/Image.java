package framework.cars.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 21.06.2017.
 */
public class Image extends BaseElement {
    WebElement image;

    public Image(WebElement image) {
        this.image = image;
    }

    public Image(By by){
        this.image = findElement(by);
    }

    @Override
    public void click() {
        image.click();
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

    public Image findElementByInd(List<Image> elements, int ind) {
        return  elements.get(ind);

    }

    public List<Image> getConvertedElements(String by) {
        List<WebElement> webElementList = super.findElements(by);
        List<Image> imageList= new ArrayList<>();
        for(WebElement webel: webElementList){
            imageList.add(new Image(webel));
        }
        return imageList;
    }
}
