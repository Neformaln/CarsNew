package framework.cars.pages;

import framework.GeneralFunctions;
import framework.cars.elements.BasePage;
import framework.cars.elements.Button;
import framework.cars.elements.ComboBox;
import framework.cars.elements.Label;
import framework.cars.menu.Menu;
import framework.cars.model.Car;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Properties;

/**
 * Created by User on 21.06.2017.
 */
public class MainPage extends BasePage {
    String selectAMakeLocator = "selectAMakeLocator";
    String selectAMakeOptionsLocator = "selectAMakeOptionsLocator";
    String selectAModelLocator = "selectAModelLocator";
    String selectAModelOptionsLocator = "selectAModelOptionsLocator";
    String selectAYearLocator = "selectAYearLocator";
    String selectAYearOptionsLocator = "selectAYearOptionsLocator";
    String btnSearchLocator = "btnSearchLocator";
    Button searchBtn;
    Properties locatorproperties;

    public Menu menu = new Menu();

    public MainPage(){
        super(By.xpath("//div[@class='promo-copy container']"), null);
    }


    public Car InputRandomValue(){
        BrowserFactory.waitPageToLoad();
        BrowserFactory.waitImplicitly();
        locatorproperties = getLocatorProperties();
        List<Label> listSelectMake = Label.getConvertedElements(locatorproperties.getProperty(selectAMakeOptionsLocator));
        int rand = GeneralFunctions.generateRandomValue(listSelectMake.size());
        String locator = locatorproperties.getProperty(selectAMakeOptionsLocator) + "[" + rand + "]";
        ComboBox cmbMake = new ComboBox(By.xpath(locatorproperties.getProperty(selectAMakeLocator)), By.xpath(locator));
        cmbMake.dropComboBox();
        Car car = new Car();
        car.setMake(cmbMake.getText());
        List<Label> listSelectModel = Label.getConvertedElements(locatorproperties.getProperty(selectAModelOptionsLocator));
        rand = GeneralFunctions.generateRandomValue(listSelectModel.size());
        locator = locatorproperties.getProperty(selectAModelOptionsLocator) + "[" + rand + "]";
        ComboBox cmbModel = new ComboBox(By.xpath(locatorproperties.getProperty(selectAModelLocator)), By.xpath(locator));
        cmbModel.dropComboBox();
        car.setModel(cmbModel.getText());
        List<Label> listSelectYear = Label.getConvertedElements(locatorproperties.getProperty(selectAYearOptionsLocator));
        rand = GeneralFunctions.generateRandomValue(listSelectYear.size());
        locator = locatorproperties.getProperty(selectAYearOptionsLocator) + "[" + rand + "]";
        ComboBox cmbYear = new ComboBox(By.xpath(locatorproperties.getProperty(selectAYearLocator)), By.xpath(locator));
        cmbYear.dropComboBox();
        car.setYear(cmbYear.getText());
        BrowserFactory.waitImplicitly();
        searchBtn = new Button(By.xpath(locatorproperties.getProperty(btnSearchLocator)));
        searchBtn.submit();
        return car;
    }
}
