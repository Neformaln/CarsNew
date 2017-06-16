package framework.steam.forms;


import framework.steam.services.GeneralFunctions;
import framework.webdriver.browser.BrowserFactory;
import framework.webdriver.elements.Button;
import framework.webdriver.elements.Label;
import framework.webdriver.elements.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * Created by d.korobkin on 6/16/17.
 */
public class DescriptionPage extends BasePage {
    Select daySelect;
    Select concreteDaySelect;
    Select monthSelect;
    Select concreteMonthSelect;
    Select yearSelect;
    Select concreteYearSelect;
    Button buttonEnter;
    Button buttonInstall;
    Label discountLabel;
    Label priceLabel;
    String daySelectLocatorKey = "daySelectLocator";
    String dayOptionLocatorKey = "dayOptionLocator";
    String monthSelectLocatorKey = "monthSelectLocator";
    String monthOptionLocatorKey = "monthOptionLocator";
    String yearSelectLocatorKey = "yearSelectLocator";
    String yearOptionLocatorKey = "yearOptionLocator";
    String enterButtonLocatorKey = "enterButtonLocator";
    String installButtonLocatorKey = "installButtonLocator";
    String discountLocator2Key = "discountLocator2";
    String finalPriceLocatorKey = "finalPriceLocator";
    private static final String TEXT_LOCATORS_PATH = "%s_text.properties";

    public DescriptionPage() {
    }

       public void chooseAgeIfExist() {
        Properties locatorProperties = getLocatorProperties();
        BrowserFactory.waitWithIgnoring();
        try {
            BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(daySelectLocatorKey));
            daySelect = new Select(By.xpath(locatorProperties.getProperty(daySelectLocatorKey)));
            daySelect.click();
            daySelect.click();

            concreteDaySelect = new Select(By.xpath(locatorProperties.getProperty(dayOptionLocatorKey)));
            concreteDaySelect.click();

            BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(monthSelectLocatorKey));

            monthSelect = new Select(By.xpath(locatorProperties.getProperty(monthSelectLocatorKey)));
            monthSelect.click();
            monthSelect.click();

            concreteMonthSelect = new Select(By.xpath(locatorProperties.getProperty(monthOptionLocatorKey)));
            concreteMonthSelect.click();


            yearSelect = new Select(By.xpath(locatorProperties.getProperty(yearSelectLocatorKey)));
            yearSelect.click();
            yearSelect.click();

            BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(yearSelectLocatorKey));
            concreteYearSelect = new Select(By.xpath(locatorProperties.getProperty(yearOptionLocatorKey)));
            concreteYearSelect.click();
            GeneralFunctions generalFunctions= new GeneralFunctions();
            String lang = getProperties().getProperty("language");

            String nameFile=String.format(TEXT_LOCATORS_PATH,lang);

            String prop=new String (generalFunctions.readProperties(nameFile).getProperty("enterButton"));

            prop=new String (prop.getBytes("ISO-8859-1"), "UTF-8");
            String locator=new String(String.format(locatorProperties.getProperty(enterButtonLocatorKey),prop));

            buttonEnter = new Button(By.xpath(locator));
            buttonEnter.click();


        } catch (TimeoutException e) {

        } catch (NoSuchElementException e) {

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public boolean isSimilarPriceDiscount(List<String> list) {
        Properties locatorProperties = getLocatorProperties();
        BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(discountLocator2Key));
        discountLabel = new Label(By.xpath(locatorProperties.getProperty(discountLocator2Key)));
        priceLabel = new Label(By.xpath(locatorProperties.getProperty(finalPriceLocatorKey)));
        List<String> new_requisites = new ArrayList<>();
        new_requisites.add(discountLabel.getText());
        new_requisites.add(priceLabel.getText().split(" ")[0]);
        return list.equals(new_requisites);
    }

    public void clickOnInstall()  {
        Properties locatorProperties = getLocatorProperties();
        BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(installButtonLocatorKey));
        String str = new String(locatorProperties.getProperty(installButtonLocatorKey));
        buttonInstall = new Button(By.xpath(str));
        buttonInstall.click();
    }
}
