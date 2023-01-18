package com.pages;

import com.base.BaseClass;
import com.base.BasePage;
import com.repo.UsersPageRepo;
import com.utility.ExcelSheetUtils;
import java.util.ArrayList;
import java.util.HashMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends UsersPageRepo {

	public WebDriver driver = null;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*************************** Users Page Methods ***************************/

	/* Method Number 01 */

	public boolean checkUsersTableData() throws Exception {
		
		ArrayList<String> actList = new ArrayList<String>();
		
		ArrayList<String> expList = BasePage
				.readExcelSheetDataUsingArraylist("OfflineWebSiteData.xlsx", "userdata");
		
		for (WebElement data : userTable) {

			String value = data.getText();

			actList.add(value);
		}
		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Users table data matches with as expected.");

			return true;

		} else {

			log.info("Users table data doesn't matches with as expected.");

			return false;

		}
	}
	

	/* Method Number 02 */

	public boolean checkUserNameAndCourses() throws Exception {
		
		HashMap<String, String> actMap = new HashMap<String, String>();

		HashMap<String, String> expMap = BasePage
				.readSpecificExcelSheetDataUsingHashMap("OfflineWebSiteData.xlsx","userdata", 1 , 4);
		
		for (int i = 0; i < userName.size(); i++) {
			String key = userName.get(i).getText();
			String value = course.get(i).getText();
			actMap.put(key, value);
		}

		log.info("Actual Map : " + actMap);
		log.info("Expected Map : " + expMap);

		if (actMap.equals(expMap)) {

			log.info("Users name and their courses matches with as expected.");

			return true;

		} else {

			log.info("Users name and their courses doesn't matches with as expected.");

			return false;
		}
	}

	
	/* Method Number 03 */

	public boolean checkUserNameAndState() throws Exception {
		
		HashMap<String, String> actMap = new HashMap<String, String>();
		
		HashMap<String, String> expMap = BasePage
				.readSpecificExcelSheetDataUsingHashMap("OfflineWebSiteData.xlsx","userdata", 1 , 6);
		
		for (int i = 0; i < userName.size(); i++) {
			String key = userName.get(i).getText();
			String value = userState.get(i).getText();
			actMap.put(key, value);
		}

		log.info("Actual Map : " + actMap);
		log.info("Expected Map : " + expMap);

		if (actMap.equals(expMap)) {

			log.info("Users name and their states matches with as expected.");

			return true;

		} else {

			log.info("Users name and their states doesn't matches with as expected.");

			return false;
		}
	}

	
	/* Method Number 04 */

	public boolean checkUserEmailAddress() throws Exception {
		
		HashMap<String, String> actMap = new HashMap<String, String>();

		HashMap<String, String> expMap = ExcelSheetUtils
				.readSpecificExcelSheetDataUsingHashMap("OfflineWebSiteData.xlsx", "userdata", 1 , 2);

		for (int i = 0; i < userEmail.size(); i++) {

			String key = userName.get(i).getText();

			String value = userEmail.get(i).getText();

			if (value.contains("@gmail.com")) {

				actMap.put(key, value);
			}
		}

		log.info("Actual Map : " + actMap);
		log.info("Expected Map : " + expMap);

		if (actMap.equals(expMap)) {

			log.info("Users name and their emails matches with as expected.");

			return true;

		} else {

			log.info("Users name and their emails doesn't matches with as expected.");

			return false;
		}
	}

	
	/* Method Number 05 */

	public boolean checkUserGender() throws Exception {
		
		HashMap<String, String> actMap = new HashMap<String, String>();

		HashMap<String, String> expMap = ExcelSheetUtils
				.readSpecificExcelSheetDataUsingHashMap("OfflineWebSiteData.xlsx", "userdata", 1 , 5);

		for (int i = 0; i < userGender.size(); i++) {
			
			String key = userName.get(i).getText();
			
			String value = userGender.get(i).getText();
			
			if (value.equals("Male") || value.equals("Female")) {
				
				actMap.put(key, value);
			}
		}

		log.info("Actual Map : " + actMap);
		log.info("Expected Map : " + expMap);

		if (actMap.equals(expMap)) {

			log.info("Users name and their genders matches with as expected.");

			return true;
		} else {

			log.info("Users name and their genders doesn't matches with as expected.");

			return false;
		}
	}
	

	/* Method Number 06 */

	public boolean checkUserMobileNumber() throws Exception {
		
		HashMap<String, String> actMap = new HashMap<String, String>();
		 
		HashMap<String, String> expMap = BasePage
				.readSpecificExcelSheetDataUsingHashMap("OfflineWebSiteData.xlsx","userdata", 1 , 3);

		for (int i = 0; i < userMobileNumber.size(); i++) {
			
			String key = userName.get(i).getText();
			
			String value = userMobileNumber.get(i).getText();
			
			if (value.length() == 10) {
				
				actMap.put(key, value);
			}
		}

		log.info("Actual Map : " + actMap);
		log.info("Expected Map : " + expMap);

		if (actMap.equals(expMap)) {
			
			log.info("Users name and their mobile numbers having ten digit matches with as expected.");

			return true;
		} else {

			log.info("Users name and their mobile numbers having ten digit doesn't matches with as expected.");

			return false;
		}
	}
	

	/* Method Number 07 */

	public boolean checkUserCanBeDeleted() throws Exception {
		ArrayList<String> actList = new ArrayList<String>();
		
		ArrayList<String>  expList = BaseClass.readExcelSheetDataUsingArraylist("OfflineWebSiteData.xlsx",
				"AlertMessage");

		for (int i = 0; i < userDeleteButton.size(); i++) {

			if (i == 0 || i == 2) {
				clickOnWebElement(userDeleteButton.get(i));

				Alert alert = driver.switchTo().alert();

				String alertName = alert.getText();

				alert.accept();

				actList.add(alertName);

			} else {
				clickOnWebElement(userDeleteButton.get(i));

				Alert alert = driver.switchTo().alert();

				String nextAlert = alert.getText();

				alert.accept();

				String nextAlert1 = alert.getText();

				alert.accept();

				actList.add(nextAlert);

				actList.add(nextAlert1);

			}

		}

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Delete button after clicking all alert messages matches with as expected.");

			return true;

		} else {

			log.info("Delete button after clicking all alert messages doesn't matches with as expected.");

			return false;

		}
	}

	
	/* Method Number 08 */

	public boolean checkAddNewUserFUnctionality() throws Exception {

		ArrayList<String> data = BaseClass
				.readExcelSheetDataUsingArraylist("OfflineWebSiteData.xlsx","addnewUserDara");

		clickOnWebElement(addNewUserLink);

		SendValue(enterUserName, data.get(0));

		SendValue(enterMobileNumber, data.get(1));

		SendValue(enterEmail, data.get(2));

		SendValue(enterCourse, data.get(3));

		selectRadioButtonByValue(chooseGender, data.get(4));

		selectByVisibleText(clickOnSelect, data.get(5));

		SendValue(enterPassword, data.get(6));

		SendValue(enterFriendMobileNumber, data.get(7));

		clickOnWebElement(submitButton);

		Alert alert = driver.switchTo().alert();

		String value = alert.getText();

		alert.accept();

		if (value.equals("User Added Successfully. You can not see added user.")) {

			clickOnWebElement(userLink);

			log.info("New user added successfully message is as expectd.");

			return true;

		} else {

			log.info("New user added successfully message is not as expectd.");

			return false;

		}
	}

}
