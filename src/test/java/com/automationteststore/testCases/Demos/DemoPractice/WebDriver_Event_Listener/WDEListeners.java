package com.automationteststore.testCases.Demos.DemoPractice.WebDriver_Event_Listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WDEListeners {

	public static void main(String[] args) {
		String baseUrl = "https://www.expedia.com/";
		WebDriver driver = new FirefoxDriver();
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		HandleEvents he = new HandleEvents();
		eDriver.register(he);
		
		eDriver.get(baseUrl);
		eDriver.findElement(By.id("tab-flight-tab")).click();
		
	}
}