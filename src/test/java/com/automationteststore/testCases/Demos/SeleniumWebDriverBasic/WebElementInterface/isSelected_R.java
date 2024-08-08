package testCases.Demos.SeleniumWebDriverBasic.WebElementInterface;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class isSelected_R {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void findElements() throws Exception {
        driver.get("https://facebook.com");
        WebElement check_box = driver.findElement(By.id("persist_box"));
        Thread.sleep(3000);
        boolean BeforeSelected = check_box.isSelected();
        System.out.println("Keep me logged in check box status before checking it : " + BeforeSelected);
        check_box.click();
        boolean AfterSelected = check_box.isSelected();
        System.out.println("Keep me logged in check box status after checking it : " + AfterSelected);
        Thread.sleep(3000);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}

