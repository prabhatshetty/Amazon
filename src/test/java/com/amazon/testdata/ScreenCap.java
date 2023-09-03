package com.amazon.testdata;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenCap {
	public static String screenCap(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenCap\\" + name + ".png");
		// File dest=new
		// File("D:\\Code_F\\Framework_M\\src\\test\\resources\\ScreenCap");
		Files.copy(src, dest);
		return System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenCap\\" + name + ".png";
	}

}
