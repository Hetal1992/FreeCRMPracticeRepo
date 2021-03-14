package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class HomePage extends TestBase{
	
	
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement userNameLabel;
	
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactLink;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUsername() {
	
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public TaskPage clickOnTaskLink() {
		taskLink.click();
		return new TaskPage();
	}
	
	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		NewContactLink.click();
		
		
	}
	
}