package framework.forms;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by d.korobkin on 6/9/17.
 */
public class CategoriesPage {

    private WebDriver driver;

    private By nameCategoriesLocator = By.xpath(".//*[@id='container']/div/div[2]/div/div/div[2]/div[2]/div[2]/h1");

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }


}
