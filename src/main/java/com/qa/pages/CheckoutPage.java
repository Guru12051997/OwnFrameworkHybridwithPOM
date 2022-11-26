package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class CheckoutPage extends TestBase {
	@FindBy(xpath = "//label[normalize-space()='I want to use a new address']")
	@CacheLookup
	WebElement newAddressbtn;

	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	@CacheLookup
	WebElement firstName;

	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	@CacheLookup
	WebElement lastName;

	@FindBy(xpath = "//input[@id='input-payment-company']")
	@CacheLookup
	WebElement companyName;

	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	@CacheLookup
	WebElement address;

	@FindBy(xpath = "//input[@id='input-payment-city']")
	@CacheLookup
	WebElement cityName;
	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	@CacheLookup
	WebElement postCode;

	@FindBy(xpath = "//select[@id='input-payment-zone']")
	@CacheLookup
	WebElement regionDropdown;

	@FindBy(xpath = "//input[@id='button-payment-address']")
	@CacheLookup
	WebElement continuebtn;

	@FindBy(id = "button-shipping-address")
	@CacheLookup
	WebElement continuebtnDelivery;

	@FindBy(id = "button-shipping-method")
	@CacheLookup
	WebElement continuebtnDeliveryMethod;

	@FindBy(xpath = "//input[@name='agree']")
	@CacheLookup
	WebElement Checkbox;
	@FindBy(xpath = "//input[@id='button-payment-method']")

	WebElement Checkboxclick;

	@FindBy(xpath = "	//input[@id='button-confirm']")
	@CacheLookup
	WebElement ConfirmOrderbtn;

// Initialise the page object

	public CheckoutPage() {
		PageFactory.initElements(driver, this);// use also LoginPage.class
	}

// Actions Methods
	public String ValidateCheckoutPagePageTitle() {
		return driver.getTitle();

	}

	public void checkoutPageClick() {
		newAddressbtn.click();

	}

	public void addInformation(String FName, String LName, String CName, String ADDRESS, String Postcode,
			String CityName) {
		firstName.sendKeys(FName);
		lastName.sendKeys(LName);
		companyName.sendKeys(CName);
		address.sendKeys(ADDRESS);
		cityName.sendKeys(CityName);
		postCode.sendKeys(Postcode);
	}

	public void DropdownValueCountry(String Country) {
		Select select = new Select(driver.findElement(By.xpath("//select[@id='input-payment-country']")));
		select.selectByVisibleText(Country);
	}

	public void DropdownValueRegion(String Region) {
		Select select1 = new Select(regionDropdown);
		select1.selectByVisibleText(Region);
	}

	public void continueClick() {
		continuebtn.click();
		continuebtnDelivery.click();
		continuebtnDeliveryMethod.click();
		Checkbox.click();
		Checkboxclick.click();

	}

	public void continueClick1() {

		ConfirmOrderbtn.click();

	}

}
