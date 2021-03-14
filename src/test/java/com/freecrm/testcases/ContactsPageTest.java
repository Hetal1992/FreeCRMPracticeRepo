package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.ContactsPage;
import com.freecrm.pages.DealsPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	DealsPage dealspage;
	
	String sheetName="contacts";
	
	public ContactsPageTest() {
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
		testutil.switchToMainFrame();
		contactspage = homepage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void ContactsLabelTest() {
		Assert.assertTrue(contactspage.verifyContactLabel(), "Contacts Label is missing on this page");	
	}
	
	@Test(priority=2)
	public void SingleContactSelection() throws InterruptedException {
	Thread.sleep(3000);
	contactspage.selectContactByName("Abdul Kalam" );	
	}
	
	@Test(priority=3)
	public void multiContactSelection() throws InterruptedException {
	Thread.sleep(3000);
	contactspage.selectContactByName("Abdul Kalam" );
	contactspage.selectContactByName("Aman Test");
	}
	
	/*
	 * @DataProvider public void getCRMTestData() { Object data[][] =
	 * TestUtil.getTestData(sheetName);
	 * 
	 * }
	 */
	
	
	@Test(priority=4)
	public void validateCreateNewContact() throws InterruptedException {
		homepage.clickOnNewContact();
		contactspage.createNewContact("Mr.", "Tom", "Peter", "Thomas", "MD", "Google");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();		
	}
}
