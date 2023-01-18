package com.repo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BasePage;

public class UsersPageRepo extends BasePage{
	

    /***************************Users Page WebElements***************************/

	@FindBy(xpath = "//table[@class='table table-hover']//following::tbody//child::tr//td")
    public List<WebElement> userTable;
	
	@FindBy(xpath = "//table[@class='table table-hover']//following::tbody//child::tr//td[2]")
	public List<WebElement> userName;
	
	@FindBy(xpath = "//table[@class='table table-hover']//following::tbody//child::tr//td[5]")
	public List<WebElement> course;
	
	@FindBy(xpath = "//table[@class='table table-hover']//following::tbody//child::tr//td[3]")
	public List<WebElement> userEmail;
	
	@FindBy(xpath = "//table[@class='table table-hover']//following::tbody//child::tr//td[6]")
	public List<WebElement> userGender;
	
	@FindBy(xpath = "//table[@class='table table-hover']//following::tbody//child::tr//td[7]")
	public List<WebElement> userState;
	
	@FindBy(xpath = "//table[@class='table table-hover']//following::tbody//child::tr//td[4]")
	public List<WebElement> userMobileNumber;
	
	@FindBy(xpath = "//table//tr//td//a//span[@title='Click to Delete']")
	public List<WebElement> userDeleteButton;
	
	@FindBy(xpath = "//a//button[text()='Add User']")
	public WebElement addNewUserLink;
	
	@FindBy(xpath = "//input[@id='username']")
	public WebElement enterUserName;
	
	@FindBy(xpath = "//input[@id='mobile' and @placeholder='Mobile']")
	public WebElement enterMobileNumber;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement enterEmail;
	
	@FindBy(xpath = "//input[@id='course']")
	public WebElement enterCourse;
	
	@FindBy(xpath = "//div[@class='col-sm-4']//input[@name='gender']")
	public List<WebElement> chooseGender;
	
	@FindBy(xpath = "//div[@class='col-sm-4']//select[@class='form-control']//option")
	public List<WebElement> selectState;
	
	@FindBy(xpath = "//div[@class='col-sm-4']//select")
	public WebElement clickOnSelect;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement enterPassword;
	
	@FindBy(xpath = "//input[@id='mobile' and @placeholder='FriendMobile']")
	public WebElement enterFriendMobileNumber;
	
	@FindBy(xpath = "//button[@id='submit' and text()='Submit']")
	public WebElement submitButton;
	
	@FindBy(linkText = "Users")
	public WebElement userLink;
	
	

}
