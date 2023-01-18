package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;
import com.repo.RegistrationPageRepo;

public class RegistrationPage extends RegistrationPageRepo {

	public WebDriver driver = null;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**************************** Registration Page Methods***************************/

	/* Method Number 01 */

	public boolean checkRegisterNewMembership() throws Exception {

		ArrayList<String> value = BasePage.readExcelSheetDataUsingArraylist("OfflineWebSiteData.xlsx", "registerdata");

		SendValue(userName, value.get(0));

		SendValue(userMobileNumber, value.get(1));

		SendValue(userEmail, value.get(2));

		SendValue(userPassword, value.get(3));

		clickOnWebElement(signInButton);

		String text = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		if (text.equals("User registered successfully.")) {

			log.info("Alert text matches as expected");

			return true;

		} else {

			log.info("Alert text doesn't matches as expected");

			return false;

		}
	}
	

	/* Method Number 02 */

	public boolean checkAlreadyRegisterLinkIsClickable() {

		clickOnWebElement(alreadyUser);

		String title = driver.getTitle();

		if (title.equals("JavaByKiran | Log in")) {

			clickOnWebElement(registerLink);

			log.info("Already register link after clicking page title matches as expected.");

			return true;

		} else {

			log.info("Already register link after clicking page title doesn't matches as expected.");

			return false;
		}
	}
	

	/* Method Number 03 */

	public boolean checkUserNameErrorMessage() {

		SendValue(userName, "");

		SendValue(userMobileNumber, "9876543210");

		SendValue(userEmail, "abc@gmail.com");

		SendValue(userPassword, "123456");

		clickOnWebElement(signInButton);

		String text = userNameError.getText();

		if (text.equals("Please enter Name.")) {

			driver.navigate().refresh();

			log.info("Username error message is as expected");

			return true;

		} else {

			log.info("Username error message is not as expected");

			return false;
		}
	}
	
	
	/* Method Number 04 */

	public boolean checkMobileNumberErrorMessage() {

		SendValue(userName, "Rajendra");

		SendValue(userMobileNumber, "");

		SendValue(userEmail, "abc@gmail.com");

		SendValue(userPassword, "123456");

		clickOnWebElement(signInButton);

		String text = mobileNumberError.getText();

		if (text.equals("Please enter Mobile.")) {

			driver.navigate().refresh();

			log.info("User mobile number error message is as expected");

			return true;

		} else {

			log.info("User mobile number error message is not as expected");

			return false;
		}
	}
	
	
	/* Method Number 05 */

	public boolean checkEmailErrorMessage() {

		SendValue(userName, "Rajendra");

		SendValue(userMobileNumber, "9876543210");

		SendValue(userEmail, "");

		SendValue(userPassword, "123456");

		clickOnWebElement(signInButton);

		String text = emailError.getText();

		if (text.equals("Please enter Email.")) {

			driver.navigate().refresh();

			log.info("User email address error message is as expected");

			return true;

		} else {

			log.info("User email address error message is not as expected");

			return false;
		}
	}
	
	
	/* Method Number 06 */

	public boolean checkPasswordErrorMessage() {

		SendValue(userName, "Rajendra");

		SendValue(userMobileNumber, "9876543210");

		SendValue(userEmail, "xyz@gmail.com");

		SendValue(userPassword, "");

		clickOnWebElement(signInButton);

		String text = passwordError.getText();

		if (text.equals("Please enter Password.")) {

			driver.navigate().refresh();

			log.info("User password error message is as expected");

			return true;

		} else {

			log.info("User password error message is not as expected");

			return false;
		}
	}

}
