package helpers.PopUpUrlCheckUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webdriverUtilities.WebDrv;

import java.util.Set;

public class PopUpUrlCheckUtils {

    private WebDriver driver;

    public PopUpUrlCheckUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void checkByClickingOnTheLinkTakesToExpectedUrl(WebElement linkName, String expectedUrl) {
        linkName.click();
        String parentWindow = WebDrv.getInstance().getWebDriver().getWindowHandle();

        Set<String> windowHandles = WebDrv.getInstance().getWebDriver().getWindowHandles();
        for (String handle : windowHandles) {
            WebDrv.getInstance().getWebDriver().switchTo().window(handle);
        }
        Assert.assertEquals("Link url is not matching", expectedUrl, WebDrv.getInstance().getWebDriver().getCurrentUrl());
        WebDrv.getInstance().getWebDriver().close();
        WebDrv.getInstance().getWebDriver().switchTo().window(parentWindow);
    }
}