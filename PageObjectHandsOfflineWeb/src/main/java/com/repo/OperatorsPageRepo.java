package com.repo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class OperatorsPageRepo extends BasePage{
	
/**************************** Operators Page WebElements***************************/
	

	@FindBy(xpath = "//div[@class='box-body table-responsive no-padding']//following::tbody//tr//td")
	public List<WebElement> operatorTableData;

	@FindBy(xpath = "//div[@class='box-body table-responsive no-padding']//following::tbody//tr//td[2]")
	public List<WebElement> operatorsName;

	@FindBy(xpath = "//div[@class='box-body table-responsive no-padding']//following::tbody//tr//td[3]")
	public List<WebElement> operatorsCourse;

	@FindBy(xpath = "//div[@class='box-body table-responsive no-padding']//following::tbody//tr//td[4]")
	public List<WebElement> wayToConnect;

	@FindBy(xpath = "//div[@class='box-body table-responsive no-padding']//following::tbody//tr//td[6]")
	public List<WebElement> timingOfOperator;

	@FindBy(xpath = "//div[@class='box-body table-responsive no-padding']//following::tbody//tr//td[5]")
	public List<WebElement> contactNumberOfOperator;
	

	
	

}
