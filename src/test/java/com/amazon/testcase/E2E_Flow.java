package com.amazon.testcase;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class E2E_Flow extends Base_Test {
	@Test(priority = 1)
	public void OneTest() {
	//	extent.createTest("Scrolling to the Bottom of the Page");
		/** Scrolling to bottom of the Page */
		bp.scrollIntoView();
	}

	@Test(priority = 2)
	public void TwoTest() {
		//extent.createTest("Searching a product");
		/** Searching a product */
		hp.clickingOnSearchBox();
		hp.enteringDataOnSearchBox(d.item());
		hp.clickingOnSearch();
	}

	@Test(priority = 3)
	public void ThreeTest() throws InterruptedException {
		//extent.createTest("Applying Filters");
		/** Applying Filters */
		ilp.clickingOnGetItByTommorow();
		ilp.includeOutOfStock();
	}

	@Test(priority = 4)
	public void FourTest() throws InterruptedException {
		//extent.createTest("Clicking on the Product and navigating to product page");
		/** Clicking on the Product and navigating to product page */
		Thread.sleep(5000);
		ilp.clickingOntheProduct();
		pp.switchingToProductPage();
	}

	@Test(dependsOnMethods = "FourTest")
	public void FiveTest() {
		//extent.createTest("Verifying the Product");
		/** Verifying the Product */
		boolean value = pp.verifyingProductPage();
		assertFalse(value);
	}

	@Test(dependsOnMethods = "FiveTest")
	public void SixTest() {
		//extent.createTest("Adding Product to the cart");
		/** Adding Product to the cart */
		pp.addingProductToCart();
	
	}

	public void TestCase_7() {
		/** Verifying the Cart Item */
	}
}
