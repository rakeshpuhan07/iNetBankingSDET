package com.iNetBankingSDET.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBankingSDET.pageObjects.LoginPage;
import com.iNetBankingSDET.utilities.DataProvidersSDET;

//import utils.DataProviders;

public class TC_LoginTest_Excel_002 extends BaseClass {
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProvidersSDET.class)
	public void loginTest(String username, String password) {
		driver.get(BaseURL);
		logger.info("URL Entered");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Added UserName");
		lp.setPassword(password);
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
