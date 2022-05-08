package UtilityPack;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil 
{
	
	public static void captureScreenShot(WebDriver driver, String screenshotNames) {
		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/" +screenshotNames+ ".png"));
			System.out.println("Screen shot Taken");
		} 
		catch (Exception e) {			
			System.out.println("Exception while taking screen shots "+e.getMessage());
		} 
	}
}
