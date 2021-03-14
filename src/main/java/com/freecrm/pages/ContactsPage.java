
//hetal mehta
package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[@class='datacardtitle' and contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id = "middle_initial")
	WebElement middlename;
	
	@FindBy(id = "surname")
	WebElement lastname;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[contains(@value,'Load From Company')]//following-sibling:: input[@type='submit' and @value='Save' and @class='button']")
	WebElement savebtn;
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td[@class='datalistrow']//preceding-sibling::td//input[@name='contact_id']")).click();
		
	}
	
	public void createNewContact(String Title, String ftname, String mname, String ltname, String suff, String cname) throws InterruptedException {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(Title);
		
		firstName.sendKeys(ftname);
		middlename.sendKeys(mname);
		lastname.sendKeys(ltname);
		Thread.sleep(3000);
		Select select1 = new Select(driver.findElement(By.name("suffix")));
		select1.selectByVisibleText(suff);
		Thread.sleep(2000);
		company.sendKeys(cname);
		Thread.sleep(2000);
		savebtn.click();
		
	}
	
	
	
	
}
