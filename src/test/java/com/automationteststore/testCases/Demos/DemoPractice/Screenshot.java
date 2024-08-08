package com.automationteststore.testCases.Demos.DemoPractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Screenshot {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        takeSnapShot(driver);

    }

    public static void takeSnapShot(WebDriver webdriver) throws IOException {
        File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

        File destFile = new File("C:\\Users\\sbrun\\OneDrive - Learn Automation\\Desktop\\Resources\\screenshots\\"
                + timestamp() + ".png");

        FileUtils.copyFile(srcFile, destFile);

    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static class ScreenshotsDemo {
        private WebDriver driver;
        private String baseUrl;

        public static String getRandomString(int length) {
            StringBuilder sb = new StringBuilder();
            String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            for (int i = 0; i < length; i++) {
                int index = (int) (Math.random() * characters.length());
                sb.append(characters.charAt(index));
            }
            return sb.toString();
        }

        @BeforeMethod
        public void setUp() throws Exception {
            driver = new ChromeDriver();
            baseUrl = "https://www.facebook.com/";
            // Maximize the browser's window
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        public void testScreenshots() throws Exception {
            driver.get(baseUrl);
            driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
        }

        @AfterMethod
        public void tearDown() throws Exception {
            String filename = getRandomString(10) + ".png";
            String directory = System.getProperty("user.dir") + "//screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + filename));
            driver.quit();
        }
    }
}
