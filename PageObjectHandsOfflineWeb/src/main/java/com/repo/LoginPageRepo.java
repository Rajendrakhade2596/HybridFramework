package com.repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BasePage;

public class LoginPageRepo extends BasePage {
	
    /***************************Login Page WebElement***************************/
	
	@FindBy(xpath = "//input[@id='email' and @type='text']")
	public WebElement enterUserName;

	@FindBy(xpath = "//input[@id='password' and @type='password']")
	public WebElement enterPassword;

	@FindBy(xpath = "//button[text()='Sign In' and @type='submit']")
	public WebElement signInButton;
	
	@FindBy(xpath = "//b[text()='Java By Kiran']")
	public WebElement PageHeading;
	
	@FindBy(xpath = "//img[@src='pages/images/jbk.png']")
	public WebElement PageLogo;
	
	@FindBy(xpath = "//h4[text()='JAVA | SELENIUM | PYTHON']")
	public WebElement courseName;

	@FindBy(linkText = "Register a new membership")
	public WebElement registerLink;
	
	@FindBy(xpath = "//div[@id='password_error' and text()='Please enter password.']")
	public WebElement passwordErrorMessage;

	@FindBy(xpath = "//div[@id='email_error' and text()='Please enter email']")
	public WebElement emailErrorMessage;
	
	@FindBy(xpath = "//div[@id='email_error' and text()='Please enter email as kiran@gmail.com']")
	public WebElement invalidEmailErrorMessage;
	
	@FindBy(xpath = "//div[@id='password_error' and text()='Please enter password 123456']")
	public WebElement invalidPasswordErrorMessage;
	

}
