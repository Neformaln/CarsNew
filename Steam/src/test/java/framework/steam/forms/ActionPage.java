package framework.steam.forms;

import framework.steam.services.GeneralFunctions;
import framework.webdriver.browser.BrowserFactory;
import framework.webdriver.elements.Button;
import framework.webdriver.elements.Image;
import framework.webdriver.elements.Label;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by d.korobkin on 6/16/17.
 */
public class ActionPage extends BasePage {
    Image imgWithMaxDiscount;
    Button buttonSpecialTab;
    String discountLocatorKey = "discountLocator";
    String imageLocatorKey = "imageLocator";
    String priceLabelLocatorKey = "priceLabelLocator";
    String specialsLocatorKey = "specialsLocator";

    public ActionPage(){
    }

    public void clickOnSpecials() {
        Properties locatorProperties = getLocatorProperties();
        BrowserFactory.waitElementExplicide(locatorProperties.getProperty(specialsLocatorKey));
        buttonSpecialTab = new Button(By.xpath(locatorProperties.getProperty(specialsLocatorKey)));
        buttonSpecialTab.click();
    }

    public List getDiscount() {
        Properties locatorProperties = getLocatorProperties();
        BrowserFactory.waitPageToLoad();
        //BrowserFactory.waitJavascript();
        //BrowserFactory.waitJavascript();


        GeneralFunctions generalFunctions = new GeneralFunctions();
        Label label1 = new Label();
        List<Label> list = label1.getConvertedElements(locatorProperties.getProperty(discountLocatorKey));
        List<Integer> discounts = generalFunctions.getListOfDiscounts(list);
        int maxInd = generalFunctions.getIndMaxDiscount(discounts);

        List<String> ldiscount_price = new ArrayList<>();

        List<Label> l = label1.getConvertedElements(locatorProperties.getProperty(discountLocatorKey));
        List<Label> l2 = label1.getConvertedElements(locatorProperties.getProperty(priceLabelLocatorKey));
        Label labelDiscount = label1.findElementByInd(l, maxInd);
        Label labelPrice = label1.findElementByInd(l2, maxInd);
        ldiscount_price.add(labelDiscount.getText());
        ldiscount_price.add(labelPrice.getText());
        Image image = new Image();
        List<Image> gameImages = image.getConvertedElements(locatorProperties.getProperty(imageLocatorKey));
        imgWithMaxDiscount = image.findElementByInd(gameImages, maxInd);
        imgWithMaxDiscount.click();
        return ldiscount_price;
    }

}
