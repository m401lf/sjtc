package helpers;

import java.util.List;

import static com.automationteststore.base.BaseTest.driver;


public class ProductIDExtractor {

	public static String extractProductIDFromCurrentPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		List<String> urlSegments = StringSplitter.splitStringIntoAnArrayWithADelimiterAndReturnIt("/", currentUrl);
		String ProductID = "";

		if (urlSegments.size() >= 4) {
			ProductID = urlSegments.get(4);
		}

		return ProductID;
	}

}
