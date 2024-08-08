package factories;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GlobalVars;

import java.time.Duration;

import static com.automationteststore.base.BaseTest.driver;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {

	}

	public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
		WebElement element = null;
		if(waitstrategy == WaitStrategy.CLICKABLE) {
			element = 	new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait))
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitstrategy == WaitStrategy.PRESENCE) {
			element =	new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitstrategy == WaitStrategy.HANDLE_STALE_ELEMENT) {
			element = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(d-> {
						System.out.println("Searching for the element...");
						d.navigate().refresh();
						return d.findElement(by);
					});
		}
		else if(waitstrategy == WaitStrategy.NONE) {
			element = driver.findElement(by);
		}

		else if(waitstrategy == WaitStrategy.VISIBLE) {
			element =new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		return element;
	}

}
