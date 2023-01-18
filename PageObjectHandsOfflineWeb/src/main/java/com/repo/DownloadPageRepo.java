package com.repo;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BasePage;

public class DownloadPageRepo extends BasePage {
	
	 /************************Downloads Page WebElements*************************/
	 
		@FindBy(xpath = "//table[@class='table table-hover']//tr/td")
		public List<WebElement> downloadsTableData;
		
		@FindBy(xpath = "//table[@class='table table-hover']//tr/td[3]")
		public List<WebElement> vendorList;
		
		@FindBy(xpath = "//table[@class='table table-hover']//tr/td[5]")
		public List<WebElement> thirtyTwoBitSupportApps;
		
		@FindBy(xpath = "//table[@class='table table-hover']//tr/td[6]")
		public List<WebElement> sixtyFourBitSupportApps;
		
		@FindBy(xpath = "//table[@class='table table-hover']//tr/td[8]//a")
		public List<WebElement> officialSourceLink;
		
		@FindBy(xpath = "//table[@class='table table-hover']//tr/td[4]")
		public List<WebElement> version;
		
		@FindBy(partialLinkText  = "Logout")
		public WebElement logoutLink;
		
}
