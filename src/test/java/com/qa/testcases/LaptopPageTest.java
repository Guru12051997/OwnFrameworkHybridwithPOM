package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DesktopPage;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;
import com.qa.pages.laptopPage;

public class LaptopPageTest extends TestBase {
	LoginPage loginpage;
	Homepage homepage;
	DesktopPage desktopPage;
	laptopPage laptopPAge;

	public LaptopPageTest() {
		super();

	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.HomePageClick();
		desktopPage = new DesktopPage();
		laptopPAge=desktopPage.DesktopPageClick();
		//laptopPAge = new laptopPage();
	}

	@Test(priority = 1)
	public void LaptopPageTitleTest() {

		String title = laptopPAge.ValidateLaptopPageTitle();
		System.out.println("------------" + title + "---------------");
		AssertJUnit.assertEquals(title, "HP LP3065");
	}

	@Test(priority = 2)
	public void LaptopPageLClick() throws InterruptedException {

		Thread.sleep(3000);
		laptopPAge.LaptopPageClick();
		Thread.sleep(3000);
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
