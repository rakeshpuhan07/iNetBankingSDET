package com.iNetBankingSDET.utilities;

import org.testng.annotations.DataProvider;

//import utils.ExcelUtils;

public class DataProvidersSDET {
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws Exception {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\iNetBanking\\testData\\iNetData.xlsx";

		return ExcelUtilsSdet.readExcel(path, "Sheet1");
	}

}

//C:\Users\rakesh.puhan.MPHASIS\OneDrive - Mphasis\eclipse-workspaceO\iNetBankingSDET\src\test\java\com\iNetBanking\testData
