package framework.cars.pages;

import framework.cars.elements.BasePage;
import framework.cars.elements.Button;
import framework.cars.elements.CheckBox;
import framework.cars.elements.Label;
import framework.cars.model.Car;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.By;

import java.util.Properties;

/**
 * Created by User on 21.06.2017.
 */
public class CarModificationPage extends BasePage {


    String engineLocator = "engineLocator";
    String transmissionLocator = "transmissionLocator";
    String checkBoxLocator = "checkBoxLocator";
    String butttonLocator = "buttonLocator";
    Properties locatorProperties;


     private Label lblEngine = new Label(By.xpath(locatorProperties.getProperty(engineLocator)));
    private Label lblTransmision = new Label(By.xpath(locatorProperties.getProperty(transmissionLocator)));
    private CheckBox ckbCompare;
    private Button btnCompareNow;

    public CarModificationPage() {

    }

    public Car saveModification() {
        locatorProperties = getLocatorProperties();
        BrowserFactory.waitLoadingPage();
        lblEngine = new Label(By.xpath(locatorProperties.getProperty(engineLocator)));
        lblTransmision = new Label(By.xpath(locatorProperties.getProperty(transmissionLocator)));
        Car car = new Car(lblEngine.getText(), lblTransmision.getText());
        System.out.println(car.toString());
        return car;
    }

    public void checkCarToCompare() {
        locatorProperties = getLocatorProperties();
        ckbCompare = new CheckBox(By.xpath(locatorProperties.getProperty(checkBoxLocator)));
        ckbCompare.check();
        BrowserFactory.waitLoadingPage();
        btnCompareNow = new Button(By.xpath(locatorProperties.getProperty(butttonLocator)));
        btnCompareNow.click();
        BrowserFactory.waitLoadingPage();
    }
}
