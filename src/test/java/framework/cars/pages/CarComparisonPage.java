package framework.cars.pages;

import framework.cars.elements.BasePage;
import framework.cars.elements.Button;
import framework.cars.elements.ComboBox;
import framework.cars.elements.Label;
import framework.cars.model.Car;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by User on 22.06.2017.
 */
public class CarComparisonPage extends BasePage {
    private ComboBox cmbMake;
    private ComboBox cmbModel;
    private ComboBox cmbYear;
    private Button btnDone;
    Label lblFirstTransmission;
    private static final String LABEL_ADD_CAR_LOCATOR = "//div[@id='icon-div']";
    private static final String MAKE_LOCATOR = "//select[@name='makeDropdown']";
    private static final String CONCRETE_MAKE_LOCATOR = "//select[@name='makeDropdown']/option[text()='%s']";
    private static final String MODEL_LOCATOR = "//select[@name='modelDropdown']";
    private static final String CONCRETE_MODEL_LOCATOR = "//select[@name='modelDropdown']/option[text()='%s']";
    private static final String YEAR_LOCATOR = "//select[@name='yearDropdown']";
    private static final String CONCRETE_YEAR_LOCATOR = "//select[@name='yearDropdown']/option[text()='%s']";
    private static final String BUTTON_LOCATOR = "//button[@class='modal-button']";
    private static final String FIRST_ENGINE_LOCATOR="//cars-compare-compare-info[@header='Engine']/*/span";
    private static final String FIRST_TRANSMISSION_LOCATOR="//cars-compare-compare-info[@header='Transmission']/*/span";////div[1]//p[contains(text(),'speed')][1]";

    private Label lblAddCar;

    public CarComparisonPage() {
    }

    public void clickToAddAnotherCar() {
        lblAddCar = new Label(By.xpath(LABEL_ADD_CAR_LOCATOR));
        lblAddCar.click();
    }

    public void selectParametrsAndDone(Car firstCar) {
        String locator = String.format(CONCRETE_MAKE_LOCATOR, firstCar.getMake());
        cmbMake = new ComboBox(By.xpath(MAKE_LOCATOR), By.xpath(locator));
        cmbMake.dropComboBox();
        locator = String.format(CONCRETE_MODEL_LOCATOR, firstCar.getModel());
        cmbModel = new ComboBox(By.xpath(MODEL_LOCATOR), By.xpath(locator));
        cmbModel.dropComboBox();
        locator = String.format(CONCRETE_YEAR_LOCATOR, firstCar.getYear());
        cmbYear = new ComboBox(By.xpath(YEAR_LOCATOR), By.xpath(locator));
        cmbYear.dropComboBox();
        btnDone= new Button(By.xpath(BUTTON_LOCATOR));
        btnDone.click();

    }

    public void compareCars(Car firstCar,Car secondCar){
        BrowserFactory.waitLoadingPage();
        List<Label> ll=Label.getConvertedElements((FIRST_TRANSMISSION_LOCATOR));
        //lblFirstTransmission =  new Label(By.xpath(FIRST_TRANSMISSION_LOCATOR));
        System.out.println(ll.size());
        System.out.println(ll.get(0).getText());
        System.out.println(ll.get(1).getText());
        String firstEngine[]=ll.get(0).getText().split(",");/////////////////////////2 машина Engine
        int colEngine=firstEngine.length/2;/////////////////////////2 машина
        for(int i=0;i<colEngine;){

        }
    }
}
