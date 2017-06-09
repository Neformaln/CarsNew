package framework.entity;

import org.openqa.selenium.WebDriver;

/**
 * Created by d.korobkin on 6/9/17.
 */
public class BaseForm {

    WebDriver driver;

    public BaseForm(WebDriver driver) {
        this.driver = driver;
    }

}
