package com.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.freecrm.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\mehta\\eclipse-workspaceNew\\FinalProjectFreeCRM\\src\\main\\java\\com\\freecrm\\config\\config.properties");
			prop.load(ip);
			
	    	}catch(FileNotFoundException e) {
		     e.printStackTrace();
	    	}catch (IOException e) {
		     e.printStackTrace();
		    }
	      }
	
	public static void intialization() {
		
		String BrowserName =  prop.getProperty("browser");
   	 if(BrowserName.equals("chrome")) {
   		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\mehta\\eclipse-workspaceNew\\FinalProjectFreeCRM\\chromedriver.exe");
			  driver = new ChromeDriver();
   	 }
   	 else if(BrowserName.equals("firefox")) {
   		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\mehta\\eclipse-workspaceNew\\FinalProjectFreeCRM\\geckodriver.exe");
   			 driver = new FirefoxDriver();
   	 }
   	 
   
	
   	 
   	 driver.manage().window().maximize();
   	 driver.manage().deleteAllCookies();
  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
   	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
   	 
   	 
   	 driver.get(prop.getProperty("url")); 
	}
	
}