package com.automationteststore.testCases.Demos.click_sendKeys_Methods;

import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.TopMenuPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

////@Listeners(testComponents.Listeners.class)

public class Click_SendKey_MethodsWithLoginTest extends BaseTest {

    Logger log = LogManager.getLogger(Click_SendKey_MethodsWithLoginTest.class);
    TopMenuPage topnaviPage;

    @Test(description = "Login test with click() method")
    public void loginTestUsingClick() throws IOException {
        topnaviPage = PageFactory.initElements(driver, TopMenuPage.class);
        //topnaviPage.clickOnLoginOrRegisterLink();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/account");
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        email.sendKeys("admin@admin.com");
        password.sendKeys("Password");
        loginButton.submit();

    }

    /*@Test(description = "Login test with Actions class method")
    public void loginTestUsingActionsClass() {
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        Actions action = new Actions(driver);
        action.moveToElement(email).sendKeys(emailAddress).build().perform();
        action.moveToElement(email).sendKeys(pass).build().perform();
        action.moveToElement(email).click().build().perform();

    }

    @Test(description = "Login test using JavascriptExecutor method")
    public void loginTestUsingJavascriptExecutor() {
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        email.sendKeys(emailAddress);
        password.sendKeys(pass);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButton);

    }

    @Test(description = "Login test using mouse action: sendKeys(Keys.RETURN)")
    public void loginTestUsingMoseAction() {
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        Actions action = new Actions(driver);
        action.moveToElement(email).sendKeys(emailAddress).build().perform();
        action.moveToElement(password).sendKeys(pass).build().perform();
        loginButton.sendKeys(Keys.RETURN);

    }

    @Test(description = "Login test using WebDriverWait")
    public void loginTestUsingWebDriverWait() {
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(emailAddress);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

    }

    @Test(description = "Testing browser")
    public void BrowserTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        //driver.quit();
    }*/

}