package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.base.BaseClass;

public class DriverUtils extends BaseClass {

	//public static WebDriver driver = new ChromeDriver();

	public static String getScreenshot(String name) {

		log.info("Taking screenshot of failed test cases");
	
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = (System.getProperty("user.dir") + "/screenshot/" + name + ".png");

		File dest = new File(path);

		try {
			log.info("Copying screenshot from source folder to destination folder");

			FileUtils.copyFile(src, dest);

		} catch (IOException e) {
			
			log.error("exception occur while copying screenshot");

			e.printStackTrace();
		}
		log.info("Screenshot taken successfully and return path of screenshot folder");

		return path;
	}
}
