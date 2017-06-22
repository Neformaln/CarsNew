package framework.cars.pages;

import framework.cars.elements.BasePage;
import framework.cars.elements.Image;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.By;

/**
 * Created by User on 21.06.2017.
 */
public class CarDescriptionPage extends BasePage {
    private static final String MODIFICATION_LOCATOR = "//div[@class='trim_listing'][1]/*/div[@class='trim_listing__image']/img";
    Image imgFirstModif;


    public CarDescriptionPage() {
    }

    public void selectFirstModification(){
        BrowserFactory.waitLoadingPage();
        BrowserFactory.waitLoadingPage();
        imgFirstModif = new Image(By.xpath(MODIFICATION_LOCATOR));
        imgFirstModif.click();
    }
}
