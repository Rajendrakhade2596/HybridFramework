package com.repo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BasePage;

public class DashboardPageRepo extends BasePage{
	
	@FindBy(xpath = "//div[@class='inner']//h3")
	public  List<WebElement> coursesName;
	
	@FindBy(xpath = "//div[@class='inner']//p")
	public  List<WebElement> detailOfcourse;

	@FindBy(xpath = "//ul[@class='sidebar-menu']//descendant::li//a")
	public  List<WebElement> sideMenubarLink;
	
	@FindBy(xpath = "//a[@class='small-box-footer' and text()='More info ']")
	public  List<WebElement> moreInfoLink;
	
	@FindBy(linkText =  "Users")
	public WebElement usersLink;
	
	@FindBy(linkText =  "Dashboard")
	public WebElement dashboardLink;
	
	@FindBy(linkText =  "Operators")
	public WebElement operatorsLink;
	
	@FindBy(partialLinkText  = "Useful Links")
	public WebElement usefulLink;
	
	@FindBy(partialLinkText  = "Downloads")
	public WebElement downloadsLink;
	

}
