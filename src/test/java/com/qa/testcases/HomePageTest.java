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
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	Homepage homepage;

	public HomePageTest() {
		super();

	}


	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 0)
	public void homePageTitleTest() {
		String title = homepage.ValidateHomePageTitle();
		System.out.println("------------" + title + "---------------");
		Assert.assertEquals(title, "My Account" ,"Home page title not matched");
	}

	@Test(priority = 1)
	public void HomePageClick() throws InterruptedException {
		homepage.HomePageClick();
		Thread.sleep(4000);
	}

	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
}
