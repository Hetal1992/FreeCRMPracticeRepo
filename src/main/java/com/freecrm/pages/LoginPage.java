package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class LoginPage extends TestBase{
	//PageFactory or we can say Object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(@class,'input-group-btn')]//input[contains(@type,'submit')]")
	WebElement loginBtn;
	
	@FindBy(linkText = "Sign Up")
	WebElement SignUp;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//after creating all webelemnets we have to create a constructor of this class 
	//and we have to initialize elements with pagefactory
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//now we have to create actions for this page
	
	public String validateLoginPageTitle() {
		return  driver.getTitle();
		
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage Login(String un, String pw) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pw);
		Thread.sleep(2000);
		loginBtn.click();
		return new HomePage();
	}
}
