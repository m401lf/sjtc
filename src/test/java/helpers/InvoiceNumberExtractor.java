package helpers;

import java.util.List;

import static com.automationteststore.base.BaseTest.driver;

public class InvoiceNumberExtractor {

	public static String extractInvoiceNumberFromCurrentPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		List<String> urlSegments = StringSplitter.splitStringIntoAnArrayWithADelimiterAndReturnIt("/", currentUrl);
		String invoiceNumber = "";

		if (urlSegments.size() >= 4) {
			invoiceNumber = urlSegments.get(4);
		}

		return invoiceNumber;
	}

}
