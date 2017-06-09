package framework.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by d.korobkin on 6/9/17.
 */
public class LoginPage {

    private WebDriver driver;

    private By loginlocator = By.xpath(".//*[@id='auth-container__forms']/div/div[2]/form/div[1]/div[1]/input");
    private By passwordLocator = By.xpath(".//*[@id='auth-container__forms']/div/div[2]/form/div[1]/div[2]/input");
    private By EnterButtonLocator = By.xpath(".//*[@id='auth-container__forms']/div/div[2]/form/div[4]/div/button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLogin(String userName){
        driver.findElement(loginlocator).sendKeys("userName");
    }

    public void setPassword(String password){
        driver.findElement(passwordLocator).sendKeys("password");
    }

    public void enterButton(){
        driver.findElement(EnterButtonLocator).click();
    }

    public void login(String userName, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loginlocator));
        setLogin(userName);
        setPassword(password);
    }

}
