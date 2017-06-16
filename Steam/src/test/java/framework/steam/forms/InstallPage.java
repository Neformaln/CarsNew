package framework.steam.forms;

import framework.steam.services.GeneralFunctions;
import framework.steam.services.HttpUtils;
import framework.webdriver.elements.Button;
import org.openqa.selenium.By;

import java.util.Properties;

/**
 * Created by d.korobkin on 6/16/17.
 */
public class InstallPage extends BasePage {
    private static final String LOCATOR = "//div[@id='about_greeting_ctn']//*//a[@id='about_install_steam_link']";
    private static final String DOWNLOAD_FILEPATH_KEY = "downloadFilePath";

    Button btnDownload;
    public InstallPage() {
    }

    public boolean isFullDownload() {
        btnDownload = new Button(By.xpath((LOCATOR)));
        String href =  btnDownload.getAttribute("href");
        Properties properties = getProperties();
        String filePath = properties.getProperty(DOWNLOAD_FILEPATH_KEY);
        GeneralFunctions generalFunctions = new GeneralFunctions();
        HttpUtils utils = new HttpUtils();
        long size = utils.getSizeOfContent(href, filePath);
        return generalFunctions.isFullDownLoad(filePath, size);
    }
}
