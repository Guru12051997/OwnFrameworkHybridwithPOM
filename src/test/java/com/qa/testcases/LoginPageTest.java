package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	Homepage homepage;

	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 0)
	public void loginPageTitleTest() {
		String title = loginpage.ValidateloginPageTitle();
		System.out.println("------------" + title + "---------------");
		Assert.assertEquals(title, "Account Login");

	}

	@Test(priority = 1)
	public void verifyLOGOTest() {
		System.out.println(loginpage.validatePageLogo());
	}

	@Test(priority = 2)
	public void loginTest() throws InterruptedException {
		Thread.sleep(3000);
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		String title1 = loginpage.ValidateloginPageTitle();
		System.out.println("------------" + title1 + "---------------");
		Assert.assertEquals(title1, "My Account");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
