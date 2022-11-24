package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactory
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement username;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[@title='naveenopencart']")
	WebElement pageLogo;

	// Initialise the page object

	public LoginPage() {
		PageFactory.initElements(driver, this);// use also LoginPage.class
	}
	// Actions Methods

	public String ValidateloginPageTitle() {
		return driver.getTitle();

	}

	public boolean validatePageLogo() {
		return pageLogo.isDisplayed();
	}

	public Homepage Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		signUpBtn.click();
		return new Homepage();
	}

}
