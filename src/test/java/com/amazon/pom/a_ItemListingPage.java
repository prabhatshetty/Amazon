package com.amazon.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class a_ItemListingPage extends a_BasePom {
	public a_ItemListingPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	By getItByTommorow = By.xpath("(//span[text()='" + d.delivery() + "'])[1]");
	By includeOutOfStock = By.xpath("//span[text()='" + d.avail() + "']");
	By product=By.xpath("//span[text()='"+d.product()+"']");

	public void clickingOnGetItByTommorow() {
		driver.findElement(getItByTommorow).click();
	}

	public void includeOutOfStock() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(includeOutOfStock).click();
	}
	
	public void clickingOntheProduct() {
		driver.findElement(product).click();
	}
}
