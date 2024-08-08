package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenShot {
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");
	
	public static String captureScreen(WebDriver driver) throws IOException{
		
		TakesScreenshot screen = (TakesScreenshot) driver;
		//File src = screen.getScreenshotAs(OutputType.FILE);
		String src = screen.getScreenshotAs(OutputType.BASE64);
		
		String dest1 = System.getProperty("user.dir")+"+screenName.png";
		
		File target = new File(dest1);
		FileUtils.copyFile(new File(src), target);
		String dest = "data:image/jpg;base64, " + src ;
		
		return dest1;
	}
	
	public static String generateFileName(ITestResult result){
		Date date = new Date();
		return result.getName()+ "_" + dateFormat.format(date);
	}

}
