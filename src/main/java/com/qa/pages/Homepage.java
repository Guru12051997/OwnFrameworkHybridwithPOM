package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class Homepage extends TestBase {
	// PageFactory

	@FindBy(xpath = "//a[normalize-space()='Desktops']")
	WebElement Desktopbtn;

	@FindBy(xpath = "//a[normalize-space()='Show All Desktops']")
	WebElement AllDesktopbtn;

	// Initialise the page object

	public Homepage() {
		PageFactory.initElements(driver, this);// use also LoginPage.class
	
		}
	// Actions Methods

	public String ValidateHomePageTitle() {
		return driver.getTitle();

	}

	public DesktopPage HomePageClick() {
		Desktopbtn.click();
		AllDesktopbtn.click();
		return new DesktopPage();
	}

}
