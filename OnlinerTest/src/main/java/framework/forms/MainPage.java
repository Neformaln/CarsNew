package framework.forms;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by d.korobkin on 6/9/17.
 */
public class MainPage {


    private By clickForEnterLocator = By.xpath("//*[@id='userbar']");
    private By clickForExitLocator = By.cssSelector(".b-top-profile__link.b-top-profile__link_secondary");
    private By liPopularCategoriesLocator = By.cssSelector(".project-navigation__item");
    private By uiPopularCategoriesLocator = By.cssSelector(".project-navigation__list");
    private By spanPopularCategoriesLocator = By.cssSelector(".project-navigation__sign");
    private String textRandomCategories;




    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    private void MainPageNavigateWindow(String mainURL){
        driver.manage().window().maximize();
        driver.navigate().to(mainURL);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void clickForEnter(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(clickForEnterLocator));
        Actions actions = new Actions(driver);
        WebElement click = driver.findElement(clickForEnterLocator);
        click.click();
    }

    public boolean clickForExitIfExist(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(clickForExitLocator));
        return driver.findElement(clickForExitLocator).isEnabled();
    }

    List<WebElement> popularCategories(){
        List<WebElement> listWebElement = driver.findElements(liPopularCategoriesLocator);
        return listWebElement;
    }

    public int randomGeneratedCategories(){
        int size = popularCategories().size();
        int max = size;
        int indexRand = 0;
        while (true) {
            indexRand = (int) Math.random() * max;
            if (driver.findElements(liPopularCategoriesLocator).get(indexRand).isDisplayed()) ;
            {
                break;
            }
        }
        return indexRand;
    }

    public String getTextRandomCategories(){
        return textRandomCategories;
    }

    public void clickForRandomCategories(){
        int indRand = randomGeneratedCategories();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(uiPopularCategoriesLocator));
        List<WebElement> listWebElement = popularCategories();
        WebElement liTheme = listWebElement.get(indRand);
        textRandomCategories = liTheme.findElement(spanPopularCategoriesLocator).getText();
        liTheme.click();
    }

    









}











