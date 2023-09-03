package com.amazon.pom;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class a_ProductPage extends a_BasePom {
	WebDriver driver;

	By productTitle = By.xpath("//span[@id=\"productTitle\"]");
	// By addingProductToCartButton = By.xpath("//span[text()='Add to Cart']");
	By addingProductToCartButton = By.cssSelector("input#add-to-cart-button");

	public a_ProductPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
	}

	public void switchingToProductPage() throws InterruptedException {
		Thread.sleep(5000);
		Set<String> wid = driver.getWindowHandles();
		Iterator<String> witr = wid.iterator();
		while (witr.hasNext()) {
			String text = witr.next();
			System.out.println(text);
			String title = driver.switchTo().window(text).getTitle();
			System.out.println(title);
			if (title.equalsIgnoreCase(
					"Gizga Essentials Laptop Bag Sleeve Case Cover Pouch with Handle for 15.6 Inch Laptop for Men & Women, Padded Laptop Compartment, Premium Zipper Closure, Water Repellent Nylon Fabric, Grey - Buy Gizga Essentials Laptop Bag Sleeve Case Cover Pouch with Handle for 15.6 Inch Laptop for Men & Women, Padded Laptop Compartment, Premium Zipper Closure, Water Repellent Nylon Fabric, Grey Online at Low Price in India - Amazon.in\r\n"
							+ "")) {

				driver.switchTo().window(title);
			}
		}
	}

	public boolean verifyingProductPage() {
		String s = driver.findElement(productTitle).getText();
		if (s.equalsIgnoreCase(d.product())) {
			return true;
		} else {
			return false;
		}

	}

	public void addingProductToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addingProductToCartButton));
		action.scrollByAmount(0, 600).build().perform();
		driver.findElement(addingProductToCartButton).click();
	}

	public void verifyingCartItem() {

	}
}
