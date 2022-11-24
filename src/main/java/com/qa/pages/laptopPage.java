package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class laptopPage extends TestBase {

	// PageFactory
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement AddToCart;

	@FindBy(xpath = "//span[@id='cart-total']")
	WebElement GoTOCart;

	@FindBy(xpath = "//strong[normalize-space()='Checkout']")
	WebElement CheckOutbtn;

	// Initialise the page object
	public laptopPage() {
		PageFactory.initElements(driver, this);// use also LoginPage.class
	}

	public String ValidateLaptopPageTitle() {
		return driver.getTitle();

	}

	public CheckoutPage LaptopPageClick() {
		AddToCart.click();
		GoTOCart.click();
		CheckOutbtn.click();
		return new CheckoutPage();
	}
}
