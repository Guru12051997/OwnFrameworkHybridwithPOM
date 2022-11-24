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

public class DesktopPageTest extends TestBase {
	LoginPage loginpage;
	Homepage homepage;
	DesktopPage desktopPage;

	public DesktopPageTest() {
		super();

	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.HomePageClick();
		desktopPage = new DesktopPage();
	}

	@Test(priority = 0)

	public void homePageTitleTest() {

		String title = desktopPage.ValidateDesktopPagePageTitle();
		System.out.println("------------" + title + "---------------");
		AssertJUnit.assertEquals(title, "Desktops");
	}

	@Test(priority = 1)
	public void DeskTopPageLaptopClick() throws InterruptedException {

		Thread.sleep(3000);
		desktopPage.DesktopPageClick();
		Thread.sleep(3000);
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
