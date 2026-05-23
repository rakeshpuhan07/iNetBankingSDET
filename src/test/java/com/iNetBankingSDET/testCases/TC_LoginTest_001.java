package com.iNetBankingSDET.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBankingSDET.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {
		driver.get(BaseURL);
		logger.info("URL Entered");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(UserName);
		logger.info("Added UserName");
		lp.setPassword(Password);
		logger.info("Added Password");
		lp.clickSubmit();

		if (driver.getTitle().equals(title)) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}

}
