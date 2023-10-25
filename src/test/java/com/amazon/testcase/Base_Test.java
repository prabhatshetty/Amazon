package com.amazon.testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.amazon.pom.a_BasePom;
import com.amazon.pom.a_HomePage;
import com.amazon.pom.a_ItemListingPage;
import com.amazon.pom.a_ProductPage;
import com.amazon.testdata.Data;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base_Test {
	protected static WebDriver driver;
	static Data d;
	static a_BasePom bp;
	static a_HomePage hp;
	static a_ItemListingPage ilp;
	static a_ProductPage pp;
	public static ExtentReports extent;
	static ExtentSparkReporter report;
	public static ExtentTest test=null;
// Testing SCM
	//Manoj 5: 37 pm
	@BeforeTest
	public void intializeBrowser() throws IOException {
		d = new Data();
		if (d.browser().equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (d.browser().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else {
			System.out.println(d.browser() + " not present");
		}
		bp = new a_BasePom(driver);
		hp = new a_HomePage(driver);
		ilp = new a_ItemListingPage(driver);
		pp = new a_ProductPage(driver);
		driver.manage().window().maximize();
		driver.get(d.amazonUrl());
	}

	@AfterTest
	public void closingBrowser() throws IOException {
		driver.close();
	}

	@BeforeSuite
	public void reportGeneration() {
		extent = new ExtentReports();
		report = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Report\\TestExecutionReport.html");
		extent.attachReporter(report);
		report.config().setTheme(Theme.DARK);
		report.config().setDocumentTitle("Documment Title");
		report.config().setReportName("ReportName");
		report.config().setReportName("Sunil");

	}

	@AfterSuite
	public void closingReport() {
		extent.flush();
	}
}
