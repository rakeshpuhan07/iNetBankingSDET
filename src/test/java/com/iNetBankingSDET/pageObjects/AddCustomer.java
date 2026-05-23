package com.iNetBankingSDET.pageObjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

	WebDriver ldriver;

	public AddCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()=\"New Customer\"]")
	@CacheLookup
	WebElement NewCustomerBtn;

	@FindBy(name = "name")
	@CacheLookup
	WebElement CustName;
	// input[@value="f"]
	@FindBy(xpath = "//input[@value=\"f\"]")
	@CacheLookup
	WebElement GenderF;
	@FindBy(id = "dob")
	@CacheLookup
	WebElement DateOfBirth;
	@FindBy(name = "addr")
	@CacheLookup
	WebElement Address;
	@FindBy(name = "city")
	@CacheLookup
	WebElement City;
	@FindBy(name = "state")
	@CacheLookup
	WebElement State;
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement Pin;
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement Phone;
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement Email;
	@FindBy(name = "password")
	@CacheLookup
	WebElement Passwrdd;
	@FindBy(name = "sub")
	@CacheLookup
	WebElement Submitt;

	@FindBy(xpath = "//p[text()=\"Customer Registered Successfully!!!\"]")
	@CacheLookup
	WebElement Success;

	public void clkAddCustomer() {
		NewCustomerBtn.click();
	}

//	public void CustName(String name) {
//		CustName.sendKeys(name);
//	}
	public void CustName() {
		CustName.sendKeys("Saloni Dash");
	}

	public void Gender() {
		GenderF.click();
	}

	public void DOB() {
		DateOfBirth.sendKeys("03242005");
	}

	public void Address() {
		Address.sendKeys("NewYork");
	}

	public void City() {
		City.sendKeys("Vegas");
	}

	public void State() {
		State.sendKeys("California");
	}

	public void Pin() {
		Pin.sendKeys("123456");
	}

	public void Phone() {
		Phone.sendKeys("1234567898");
	}

//	public void Email() {
//		Email.sendKeys("Abc@tv.com");
//	}
	

public void Email() {
    String emailId = "abc" + System.currentTimeMillis() + new Random().nextInt(1000) + "@tv.com";
    Email.sendKeys(emailId);
}


	public void Passwrdd() {
		Passwrdd.sendKeys("1234567898");
	}

	public void Submitt() {
		Submitt.click();
	}

	public String Validation() {
		String successm = Success.getText();
		return successm;
	}

}
