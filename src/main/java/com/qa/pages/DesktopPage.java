package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class DesktopPage extends TestBase {
	// PageFactory
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[3]/div/div[2]/div[1]/h4/a")
	WebElement HP_LP3065;
	
	
	
	
	
	
	
	// Initialise the page object

	public DesktopPage() {
		PageFactory.initElements(driver, this);// use also LoginPage.class
	}

	// Actions Methods
	public String ValidateDesktopPagePageTitle() {
		return driver.getTitle();

	}

	public laptopPage DesktopPageClick() {
		HP_LP3065.click();
		return new laptopPage();
	}
}
