package com.repo;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BasePage;

public class UsefulLinksPageRepo extends BasePage {
	
	  /***************************UsefulLinks Page WebElements***************************/
	
		@FindBy(xpath="//table[@class='table table-hover']//child::tbody//tr//td")
		public List<WebElement> usefulLinkTableData;
		
		@FindBy(xpath="//table[@class='table table-hover']//child::tbody//tr//td[3]//a")
		public List<WebElement> contentLink;

}
