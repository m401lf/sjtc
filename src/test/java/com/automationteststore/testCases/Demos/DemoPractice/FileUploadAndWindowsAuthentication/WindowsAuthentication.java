package testCases.Demos.DemoPractice.FileUploadAndWindowsAuthentication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class WindowsAuthentication {
    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void beforeClass() throws MalformedURLException {
        // baseUrl = "http://engprod-charter.net";
        baseUrl = "http://rsyspedia.india.rsystems.com";
        driver = new FirefoxDriver();

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void handleAuthenticationon() throws AWTException, InterruptedException, IOException {
        Runtime.getRuntime().exec("C:\\Users\\Anil Tomar\\workspace\\SeleniumWD2Tutorial\\scripts\\WindowsAuthentication.exe");
        driver.get(baseUrl);
    }

    @AfterMethod
    public void afterClass() {
    }

}