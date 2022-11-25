package com.qa.testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CheckoutPage;
import com.qa.pages.DesktopPage;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;
import com.qa.pages.laptopPage;
import com.qa.util.Testutil;

public class CheckoutPageTest extends TestBase {
	LoginPage loginpage;
	Homepage homepage;
	DesktopPage desktopPage;
	laptopPage laptopPAge;
	CheckoutPage checkoutPage;
	String sheetName = "Information";

	public CheckoutPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.HomePageClick();
		desktopPage = new DesktopPage();
		laptopPAge = desktopPage.DesktopPageClick();
		checkoutPage = laptopPAge.LaptopPageClick();

	}

	@Test(priority = 1)
	public void CheckOutPageTitleTest() {

		String title = checkoutPage.ValidateCheckoutPagePageTitle();
		System.out.println("------------" + title + "---------------");
		Assert.assertEquals(title, "Checkout", "Title not matched");
	}

//	@DataProvider
//	public Object[][] getCRMTestData() {
//		Object data[][] = Testutil.getTestData(sheetName);
//		return data;
//	}

	@Test(priority = 2)
	public void CheckoutPageLAddInformation() throws InterruptedException {

		Thread.sleep(3000);
		checkoutPage.checkoutPageClick();

		// checkoutPage.addInformation(firstName, lastName, company, Address);
		checkoutPage.addInformation("Guruprasad", "Das", "Amazon", "Electronic CityPhase -2", "Bangalore", "560037");

		checkoutPage.DropdownValueCountry("Sweden");
		checkoutPage.DropdownValueRegion("Gotland");

		checkoutPage.continueClick();

		checkoutPage.continueClick1();
		Thread.sleep(3000);
		String title1 = checkoutPage.ValidateCheckoutPagePageTitle();
		System.out.println("------------" + title1 + "---------------");
		Assert.assertEquals(title1, "Your order has been placed!", "Title not matched");

		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
