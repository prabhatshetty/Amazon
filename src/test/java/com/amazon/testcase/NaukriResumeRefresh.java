package com.amazon.testcase;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NaukriResumeRefresh {
	@Test
	public void refreshresume() throws InterruptedException
	{
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("--headless=new");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		//driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("prabhatshetty23@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Prabhat123@");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//img[@alt='naukri user profile img']")).click();
		driver.findElement(By.xpath("//a[text()='View & Update Profile']")).click();
		driver.findElement(By.xpath("//i[text()='deleteOneTheme']")).click();
		driver.findElement(By.xpath("//p[text()='Are you sure you want to delete the resume?']/../div/button")).click();
		File file = new File("./Data/PRABHAT_.SHETTY_ QA.pdf");
		//driver.findElement(By.xpath("//input[@id='attachCV']")).sendKeys("./Data/PRABHAT_.SHETTY_ QA.pdf");
		driver.findElement(By.xpath("//input[@id='attachCV']")).sendKeys(file.getAbsolutePath());
		Thread.sleep(10000);
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		driver.quit();
		
		
	}

}
