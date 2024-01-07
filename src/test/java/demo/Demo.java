package demo;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.testdata.Data;

public class Demo {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		System.out.println(System.getProperty("user.dir"));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		// Thread.sleep(5000);
		WebElement foot = driver.findElement(By.xpath("//div[contains(@class,'navFooterLine navFooterLinkLine')]"));
		Actions a = new Actions(driver);
		a.scrollToElement(foot).build().perform();
		Thread.sleep(5000);
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Data d = new Data();
		search.sendKeys(d.item() + Keys.ENTER);
		driver.findElement(By.xpath("(//span[text()='" + d.delivery() + "'])[1]")).click();
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2400)");
		//Hello moto
		// WebElement os = driver.findElement(By.linkText("Include Out of Stock"));
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("Include
		// Out of Stock"))));
		// jse.executeScript("arguments[0].click();",
		// driver.findElement(By.xpath("Include Out of Stock")));
		// wait.until(ExpectedConditions.elementToBeClickable(os));
		// a.moveToElement(os).click().build().perform();
		driver.findElement(By.xpath("//span[text()='" + d.avail() + "']")).click();
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
//				"//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-component-type='s-search-result']/descendant::span[contains(text(),'Gizga Essentials Laptop Bag Sleeve Case Cover Pouch with Handle for 15.6 Inch Laptop for Men & Women')]"))
//				));
		// Need to fail the Script

//		List<WebElement> li = driver.findElements(By.xpath(
//				"//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-component-type='s-search-result']"));
//		for (WebElement list : li) {
//			System.out.println(list.getText());
//		}
//
//		for (int i = 0; i < li.size(); i++) {
//			String s = li.get(i).getText();
//			System.out.println(s);
//		}

		driver.findElement(By.xpath(
				"//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-component-type='s-search-result']/descendant::span[contains(text(),'Gizga Essentials Laptop Bag Sleeve Case Cover Pouch with Handle for 15.6 Inch Laptop for Men & Women')]"))
				.click();
		Set<String> wid = driver.getWindowHandles();
		Iterator<String> witr = wid.iterator();
		while (witr.hasNext()) {
			String text = witr.next();
			System.out.println(text);
			String title = driver.switchTo().window(text).getTitle();
			System.out.println(title);
			if (title.contains(
					"Gizga Essentials Laptop Bag Sleeve Case Cover Pouch with Handle for 15.6 Inch Laptop for Men & Women")) {
				WebElement pannel = driver.findElement(By.xpath("//div[@class='a-box-inner']"));
				//a.moveToElement(pannel).build().perform();
				a.scrollByAmount(0, 600).build().perform();
			//	a.scrollByAmount(0, 0)

				WebElement addtoCart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
				//a.moveToElement(addtoCart).build().perform();
				wait.until(ExpectedConditions.elementToBeClickable(addtoCart));
			//	addtoCart.click();
				a.moveToElement(addtoCart).click().build().perform();
				
				driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
			}
		}
		//test newman test runSS    testtttt sunil   hhhhhh
	
//		a.moveToLocation(0, 600);
//
//		driver.findElement(By.xpath("//span[contains(text(),'Mobiles & Accessories')]")).click();
	}
}
