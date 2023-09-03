package com.amazon.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class a_HomePage extends a_BasePom {
	WebDriver driver;

	By Logo = By.xpath("//div[@id='nav-logo']");
	By Search_Box = By.xpath("//input[@id='twotabsearchtextbox']");
	By Search_Button = By.xpath("//input[@id='nav-search-submit-button']");

	public a_HomePage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
	}

	public void clickingOnAmazonLogo() {
		driver.findElement(Logo).click();
	}

	public void clickingOnSearchBox() {
		driver.findElement(Search_Box).click();
	}

	public void enteringDataOnSearchBox(String val) {
		driver.findElement(Search_Box).sendKeys(val);
	}

	public void clickingOnSearch() {
		driver.findElement(Search_Button).click();
	}
}
