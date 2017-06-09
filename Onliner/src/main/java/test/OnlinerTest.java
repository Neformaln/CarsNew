package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by d.korobkin on 6/8/17.
 */
public abstract class OnlinerTest {

    protected abstract WebDriver getDriver();

    @Test
    public void BrowserTest()  {


        System.setProperty("webdriver.gecko.driver", "/home/ITRANSITION.CORP/d.korobkin/Downloads/geckodriver");

        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.get("http://onliner.by");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Onliner.by", "");

        driver.findElement(By.xpath("//*[@id='userbar']")).click();
        driver.findElement(By.cssSelector("input.auth-box__input")).click();
        driver.findElement(By.cssSelector("input.auth-box__input")).clear();
        driver.findElement(By.cssSelector("input.auth-box__input")).sendKeys("neformaln");
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("dima1991");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();


    }

}
