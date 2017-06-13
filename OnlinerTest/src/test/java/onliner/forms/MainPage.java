package onliner.forms;

/**
 * Created by User on 11.06.2017.
 */
import onliner.elements.Button;
import onliner.services.OnlinerService;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;



public class MainPage {

    By clickForEnterLocator = By.xpath("//*[@id='userbar']");
    By clickForExitLocator = By.cssSelector(".b-top-profile__link.b-top-profile__link_secondary");
    By clickForAvatarLocator = By.xpath(".//*[@id='userbar']/div[1]/div[1]/div[1]/div");
    By liPopularCategoriesLocator = By.cssSelector(".project-navigation__item");
    By ulPopularCategoriesLocator = By.cssSelector(".project-navigation__list");
    By spanPopularCategoriesLocator = By.cssSelector(".project-navigation__sign");
    By divOpinionsLocator=By.cssSelector(".b-main-page-grid-4");
    private String textRandomCategories;
    public Button button;


    private WebDriver driver;
    private static Logger logger = Logger.getLogger(MainPage.class);


    public MainPage(WebDriver driver) {
        logger.info("Open Onliner.by");
        this.driver = driver;
        button = new Button(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void pageNavigateWindow(String mainPageUrl){
        logger.info("Maximize window");
        driver.manage().window().maximize();
        driver.navigate().to(mainPageUrl);

    }

    public String getUrl(){

        return driver.getCurrentUrl();
    }

    public void clickForEnter(){
        logger.info("Open the menu to enter the logging page");
        button.clickButton(clickForEnterLocator);

    }

    public boolean clickForExitIfExist(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(clickForExitLocator));
        return driver.findElement(clickForExitLocator).isEnabled();
    }

    List<WebElement> popularCategories(){
        List<WebElement> listWebElement = driver.findElements(liPopularCategoriesLocator);
        return listWebElement;
    }

    public int randomGeneratedCategories(){
        logger.info("Get random category from list");
        Random random = new Random();
        int size = popularCategories().size();
        int max = size;
        int indexRand;
        while (true) {
            indexRand = random.nextInt(max);
            if (driver.findElements(liPopularCategoriesLocator).get(indexRand).isDisplayed()) ;
            {
                break;
            }
        }
        return indexRand;
    }

    public String getTextRandomCategories()
    {
        return textRandomCategories;
    }

    public void clickForRandomCategories(){
        logger.info("Select a random category from the list");
        int indRand = randomGeneratedCategories();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ulPopularCategoriesLocator));
        List<WebElement> listWebElement = popularCategories();
        WebElement liTheme = listWebElement.get(indRand);
        textRandomCategories = liTheme.findElement(spanPopularCategoriesLocator).getText();
        liTheme.click();

    }

    public void findAndSaveOpinions() {

        logger.info("Search and save all opinions on the page");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(divOpinionsLocator));
        OnlinerService onlinerService = new OnlinerService();
        java.lang.String allElem =  driver.getPageSource();
        Set<String> classes=onlinerService.findClassesForOpinions(allElem);
        List<java.lang.String> data = new ArrayList<>();
        for(String cl:classes) {
            List<WebElement> l = driver.findElements(By.cssSelector("." + cl + ""));
            for(WebElement el:l){
                data.add(el.getText().split("\n")[0]);
            }
        }
        onlinerService.saveOpinionsInCsv(data);


    }


    public void logout(){

        logger.info("Logout");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(clickForAvatarLocator));
        Actions action = new Actions(driver);
        WebElement elem = driver.findElement(clickForAvatarLocator);
        elem.click();
        wait.until(ExpectedConditions.elementToBeClickable(clickForExitLocator));
        WebElement element = driver.findElement(clickForExitLocator);
        element.click();


    }

    /**
     * search enter
     */
    public boolean isEnterExist(){
        WebDriverWait  wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(clickForEnterLocator));
        return driver.findElement(clickForEnterLocator).isEnabled();
    }


    public void closeBrowser()
    {
        logger.info("Close browser");
        driver.quit();

    }


}









