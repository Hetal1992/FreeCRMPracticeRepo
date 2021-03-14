package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.ContactsPage;
import com.freecrm.pages.DealsPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	DealsPage dealspage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		intialization();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		dealspage = new DealsPage();
		loginpage = new LoginPage();	
		homepage= loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String HomePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO", "HomePage Title does not match with expected Title");
	}
	
	@Test(priority=2)
	public void UsernameVerificationTest() {
		testutil.switchToMainFrame();
		Assert.assertTrue(homepage.verifyUsername());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testutil.switchToMainFrame();
		contactspage =  homepage.clickOnContactsLink();
	}
	 
	@Test(priority=4)
	public void DealsLinkTest() {
		testutil.switchToMainFrame();
		dealspage = homepage.clickOnDealsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
