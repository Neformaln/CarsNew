package onliner.elements;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by d.korobkin on 6/12/17.
 */
public class BaseEntity {

    private WebDriver driver;


    protected By locator;
    protected String name;
    protected WebElement element;

    public BaseEntity(final By loc, final String itName) {
        locator = loc;
        name = itName;
    }





}

