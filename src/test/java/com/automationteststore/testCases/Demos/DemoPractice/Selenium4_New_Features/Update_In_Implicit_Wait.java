package com.automationteststore.testCases.Demos.DemoPractice.Selenium4_New_Features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Update_In_Implicit_Wait {

	public static void main(String[] args) throws Throwable {
		
		/*
		 * 
		 * driver.manage().timeouts().implicitlyWait(long time, TimeUnit unit) ***IS DEPRICATED***
		 * 
		 * In Selenium 4 we should use 
		 * 
		 * driver.manage().timeouts().implicitlyWait(Duration duration)
		 * 
		 */
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//webdrivers//chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		//driver.manage().timeouts().implicitlyWait(0, null)
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}
