package com.iNetBankingSDET.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBankingSDET.pageObjects.AddCustomer;
import com.iNetBankingSDET.pageObjects.LoginPage;

public class TC_Add_NewCustomer extends BaseClass{
	
	@Test
	public void AddNewCustomer() {
		driver.get(BaseURL);
		logger.info("URL Entered");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(UserName);
		logger.info("Added UserName");
		lp.setPassword(Password);
		logger.info("Added Password");
		lp.clickSubmit();
		
		AddCustomer ac = new AddCustomer(driver);
		ac.clkAddCustomer();
		logger.info("Clicked Add Customer");
		ac.CustName();
		logger.info("Name Entered");
		ac.Gender();
		logger.info("Gender Added");
		ac.DOB();
		logger.info("DOB Entered");
		ac.Address();
		logger.info("Address Entered");
		ac.City();
		logger.info("City Entered");
		ac.State();
		logger.info("State Entered");
		ac.Pin();
		logger.info("Pin Entered");
		ac.Phone();
		logger.info("Phone Entered");
		ac.Email();
		logger.info("Email Entered");
		ac.Passwrdd();
		logger.info("Password Entered");
		ac.Submitt();
		logger.info("Submit Clicked");
		
		
		String actual = ac.Validation();
		String expected = "Customer Registered Successfully!!!";

		if (expected.equals(actual)) {
		    logger.info("Login Test Passed");
		} else {
		    logger.error("Login Test Failed. Expected: " + expected + " but found: " + actual);
		}

		Assert.assertEquals(expected, actual);
	}

}
