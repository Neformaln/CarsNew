package onliner.forms;


import com.google.common.base.Function;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;




public class CategoriesPage {

    private WebDriver driver;
    By caption= By.xpath("//h1[@class='schema-header__title']");

    private static Logger logger = Logger.getLogger(CategoriesPage.class);

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;


    }


    public String getCategoryName(){
        logger.info("Get category name");
        Wait wait = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo =(WebElement) wait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(caption));

        return foo.getText();
    }

    public void returnOnStartPage() {
        driver.navigate().back();
        driver.navigate().refresh();


    }


}
