package onliner.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by d.korobkin on 6/12/17.
 */
public class Button {

    private WebDriver driver;

    public Button(WebDriver driver){
        this.driver = driver;
    }

    public void clickButton(By locator){

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }



    }
