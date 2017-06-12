package onliner.forms;


import onliner.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    private WebDriver driver;
    private static Logger logger = Logger.getLogger(LoginPage.class);
    public Button button;

    private By loginlocator = By.xpath(".//*[@id='auth-container__forms']/div/div[2]/form/div[1]/div[1]/input");
    private By passwordLocator = By.xpath(".//*[@id='auth-container__forms']/div/div[2]/form/div[1]/div[2]/input");
    private By EnterButtonLocator = By.xpath(".//*[@id='auth-container__forms']/div/div[2]/form/div[4]/div/button");

    public LoginPage(WebDriver driver)

    {
        this.driver = driver;
        button = new Button(driver);
    }

    public void setLogin(String login)

    {
        driver.findElement(loginlocator).sendKeys(login);
    }

    public void setPassword(String password)
    {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void enterButton()

    {
        button.clickButton(EnterButtonLocator);
    }

    public void login(String login, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loginlocator));
        setLogin(login);
        setPassword(password);
        enterButton();
        logger.info("Login and password input");
    }

}
