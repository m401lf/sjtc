package com.automationteststore.testCases.OrderSubmitTest;

import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.TopMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.List;
import java.util.Objects;


public class addToCart extends BaseTest {
	TopMenuPage naviPage;
	HomePage homePage;
	String productName1 = "ABSOLUE EYE PRECIOUS CELLS";
	String productName2 = "TOTAL MOISTURE FACIAL CREAM";

	String productName3 = "ABSOLUTE ANTI-AGE SPOT REPLENISHING UNIFYING TREATMENTSPF 15";

	@Test(priority = 1)
	public void add_To_Cart() {

		naviPage = new TopMenuNavigationPage(driver);
		indexPage = new IndexPage(driver);
		List<WebElement> products = driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));

		new JavaScriptHelper(driver).scrollToElement(products.get(0));
		new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait())).until(ExpectedConditions.visibilityOf(products.get(0)));
		products.stream()
				.filter(product-> product.findElement(By.cssSelector("a")).getText().contains(productName1))
				.findFirst().orElse(null).findElement(By.cssSelector("a.productcart")).click();
		products.stream()
				.filter(product-> product.findElement(By.cssSelector("a")).getText().contains(productName2))
				.findFirst().orElse(null).findElement(By.cssSelector("a.productcart")).click();
		products.stream()
				.filter(product-> product.findElement(By.cssSelector("a")).getText().contains(productName3))
				.findFirst().orElse(null).findElement(By.cssSelector("a.productcart")).click();


	}

	@Test(priority = 2)
	public void add2Cart() {

		naviPage = new TopMenuNavigationPage(driver);
		indexPage = new IndexPage(driver);
		List<WebElement> products = driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));

		new JavaScriptHelper(driver).scrollToElement(products.get(0));;
		new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait())).until(ExpectedConditions.visibilityOf(products.get(0)));
		Objects.requireNonNull(products.stream()
				.filter(product -> product.findElement(By.cssSelector("a")).getText().contains(productName2))
				.findFirst().orElse(null)).findElement(By.cssSelector("a.productcart")).click();



	}

}
