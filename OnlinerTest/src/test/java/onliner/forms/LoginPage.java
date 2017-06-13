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

    private By loginlocator = By.xpath("//input[@placeholder='Ник или e-mail']");
    private By passwordLocator = By.xpath("//input[@placeholder='Пароль']");
    private By EnterButtonLocator = By.cssSelector(".auth-box__auth-submit");

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
        logger.info("Login and password input");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loginlocator));
        setLogin(login);
        setPassword(password);
        enterButton();

    }

}
