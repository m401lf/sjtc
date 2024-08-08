package testCases.Demos.FunctionalTests;


import com.automationteststore.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class verifyButtonsTests extends BaseTest {
    WebDriver driver;

    @Test
    public void VerifyButtonsTests() {

        //Google Search button
        String searchButtonName;
        searchButtonName = driver.findElement(By.name("btnK")).getAttribute("value");
        //Assert.assertEquals("Google Search", searchButtonName);

        //I'm Feeling Lucky button
        String feelingLuckyButtonName;
        feelingLuckyButtonName = driver.findElement(By.name("btnI")).getAttribute("value");
        //Assert.assertEquals("I'm Feeling Lucky", feelingLuckyButtonName);

    }
}
