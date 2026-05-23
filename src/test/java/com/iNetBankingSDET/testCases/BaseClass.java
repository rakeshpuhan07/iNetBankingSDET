package com.iNetBankingSDET.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.Logger;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBankingSDET.utilities.ReadConfig;



public class BaseClass {

//	public static WebDriver driver;
	public WebDriver driver;
	ReadConfig readConfig = new ReadConfig(); // Because this object created the constructor will be called
	public String BaseURL = readConfig.getApplicationUrl();
	public String UserName = readConfig.getUserName();
	public String Password = readConfig.getPassword();
	public String title = "Guru99 Bank Manager HomePage";
//	public static Logger logger;
	protected static final Logger logger = LogManager.getLogger(BaseClass.class);
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		if(br.equals("Chrome")) {
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.manage().window().maximize();
		} else if(br.equals("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			 driver.manage().window().maximize();
		} else if (br.equals("Edge")){
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			 driver.manage().window().maximize();
		}
		
//		 logger = Logger.getLogger("eBanking");
//		 PropertyConfigurator.configure("log4j.properties");
		Logger logger = LogManager.getLogger(BaseClass.class);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
			
	}
	
	
	
	
}
