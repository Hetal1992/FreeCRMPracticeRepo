package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		//now create an object of LoginPage class, and we can define it at global level
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String Title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(Title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		
		boolean flag = loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest() throws InterruptedException {
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}

}
