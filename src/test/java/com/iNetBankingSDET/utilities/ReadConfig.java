package com.iNetBankingSDET.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() { // constructor once we create ReadConfig object in base class this con will automatically get called
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Exception is" + e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		String url = pro.getProperty("BaseURL");
		return url;
	}
	
	public String getUserName() {
		String username = pro.getProperty("UserName");
		return username;
	}
	
	public String getPassword() {
		String password = pro.getProperty("Password");
		return password;
	}

}
