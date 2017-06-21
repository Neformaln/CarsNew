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
    private static final String TEXT_LOCATORS_PROPERTIES = "locators.properties";
    String selectAMakeLocator = "selectAMakeLocator";
    String selectAMakeOptionsLocator = "selectAMakeOptionsLocator";
    String selectAModelLocator = "selectAModelLocator";
    String selectAModelOptionsLocator = "selectAModelOptionsLocator";
    String selectAYearLocator = "selectAYearLocator";
    String selectAYeatOptionsLocator = "selectAYeatOptionsLocator";
    String btnSearchLocator = "btnSearchLocator";


    Button searchBtn;

    public Menu menu = new Menu();

    public MainPage(){
        super(By.xpath("//div[@class='promo-copy container']"), null);
    }

    public Car InputRandomValue(){
        BrowserFactory.waitLoadingPage();
        Properties locatorproperties = getLocatorProperties();
        List<Label> listSelectMake = Label.getConvertedElements(locatorproperties.getProperty(selectAMakeOptionsLocator));
        int rand = GeneralFunctions.generateRandomValue(listSelectMake.size());
        String locator = selectAMakeLocator + "[" + rand + "]";
        ComboBox



    }


}
