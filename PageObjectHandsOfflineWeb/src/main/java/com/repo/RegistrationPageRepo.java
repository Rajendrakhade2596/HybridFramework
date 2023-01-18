package com.repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BasePage;

public class RegistrationPageRepo extends BasePage{
	
	  /***************************Registration Page WebElements***************************/
	
		@FindBy(linkText = "Register a new membership")
		public WebElement registerLink;
		
		@FindBy(xpath = "//input[@id='name' and @type='text']")
		public WebElement userName;
		
		@FindBy(xpath = "//input[@id='mobile' and @type='text']")
		public WebElement userMobileNumber;
		
		@FindBy(xpath = "//input[@id='email' and @type='text']")
		public WebElement userEmail;
		
		@FindBy(xpath = "//input[@id='password' and @type='password']")
		public WebElement userPassword;
		
		@FindBy(xpath = "//button[@type='submit']")
		public WebElement signInButton;
		
		@FindBy(linkText = "I already have a membership")
		public WebElement alreadyUser;
		
		@FindBy(xpath = "//div[@id='name_error']")
		public WebElement userNameError;
		
		@FindBy(xpath = "//div[@id='mobile_error']")
		public WebElement mobileNumberError;
		
		@FindBy(xpath = "//div[@id='email_error']")
		public WebElement emailError;
		
		@FindBy(xpath = "//div[@id='password_error']")
		public WebElement passwordError;
		
		

}
