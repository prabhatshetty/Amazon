package com.amazon.pom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.testdata.Data;

public class a_BasePom {
	static WebDriver driver;
	static Actions action;
	static Data d;
	static WebDriverWait wait;

	By footer = By.xpath("//div[contains(@class,'navFooterLine navFooterLinkLine')]");

	public a_BasePom(WebDriver driver) throws IOException {
		this.driver = driver;
		action = new Actions(driver);
		d = new Data();
		wait= new WebDriverWait(driver, Duration.ofSeconds(59));
	}

	public void scrollIntoView() {
		action.scrollToElement(driver.findElement(footer)).build().perform();
	}

}
