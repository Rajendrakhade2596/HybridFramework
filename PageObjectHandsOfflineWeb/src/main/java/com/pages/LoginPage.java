package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.repo.LoginPageRepo;

public class LoginPage extends LoginPageRepo {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	/*************************** Login Page Methods ***************************/

	/* Method Number 01 */

	public boolean checkLoginCredentials(String uname, String pass) {
		SendValue(enterUserName, uname);

		SendValue(enterPassword, pass);

		clickOnWebElement(signInButton);

		String title = driver.getTitle();

		if (title.equals("JavaByKiran | Dashboard")) {

			driver.navigate().back();

			log.info("Entered Login credential is correct and login successfully.");

			return true;

		} else {

			log.info("Failed to login.");

			return false;
		}
	}

	
	/* Method Number 02 */

	public boolean checkLoginPageLogo() {

		if (PageLogo.isDisplayed()) {

			log.info("Page logo is displayed.");

			return true;

		} else {

			log.info("Page logo is not displayed.");

			return false;

		}
	}
	

	/* Method Number 03 */

	public boolean checkLoginPageHeading() {
		String heading = getTextOfWebElement(PageHeading);

		if (heading.equals("Java By Kiran")) {

			log.info("Page heading matches as expected.");

			return true;

		} else {

			log.info("Page heading doesn't matches as expected.");

			return false;

		}
	}
	

	/* Method Number 04 */

	public boolean checkCourseName() {

		String cName = getTextOfWebElement(courseName);

		if (cName.equals("JAVA | SELENIUM | PYTHON")) {

			log.info("Page course name matches as expected.");

			return true;

		} else {

			log.info("Page course name doesn't matches as expected.");

			return false;

		}
	}

	
	/* Method Number 05 */

	public boolean checkRegisterLinkClickable() {

		clickOnWebElement(registerLink);

		String title = driver.getTitle();

		if (title.equals("JavaByKiran | Registration Page")) {
			
			driver.navigate().back();
			
			log.info("Register link after clicking page title matches as expected.");

			return true;

		} else {

			log.info("Register link after clicking page title doesn't matches as expected.");

			return false;

		}
	}
	

	/* Method Number 06 */

	public boolean checkPasswordErrorMassage() {

		SendValue(enterUserName, "kiran@gmail.com");

		SendValue(enterPassword, "");

		clickOnWebElement(signInButton);

		String errorMessage = passwordErrorMessage.getText();

		driver.navigate().refresh();

		if (errorMessage.equals("Please enter password.")) {

			log.info("Password error message is as expected");

			return true;

		} else {

			log.info("Password error message is not as expected");

			return false;

		}
	}
	

	/* Method Number 07 */

	public boolean checkEmailErrorMassage() {

		SendValue(enterUserName, "");

		SendValue(enterPassword, "123456");

		clickOnWebElement(signInButton);

		String errorMessage = emailErrorMessage.getText();

		driver.navigate().refresh();

		if (errorMessage.equals("Please enter email")) {

			log.info("Email error message is as expected");

			return true;

		} else {

			log.info("Password error message is not as expected");

			return false;

		}
	}
	

	/* Method Number 08 */

	public boolean checkEnterInvalidEmailErrorMassage() {

		SendValue(enterUserName, "ram@gmail.com");

		SendValue(enterPassword, "123456");

		clickOnWebElement(signInButton);

		String errorMessage = invalidEmailErrorMessage.getText();

		driver.navigate().refresh();

		if (errorMessage.equals("Please enter email as kiran@gmail.com")) {

			log.info("Email invalid error message is as expected");

			return true;

		} else {

			log.info("Email invalid error message is not as expected");

			return false;

		}
	}
	

	/* Method Number 09 */

	public boolean checkEnterInvalidPasswordErrorMassage() {

		SendValue(enterUserName, "kiran@gmail.com");

		SendValue(enterPassword, "654321");

		clickOnWebElement(signInButton);

		String errorMessage = invalidPasswordErrorMessage.getText();

		driver.navigate().refresh();

		if (errorMessage.equals("Please enter password 123456")) {

			log.info("Password invalid error message is as expected");

			return true;

		} else {

			log.info("Password invalid error message is not as expected");

			return false;

		}
	}

	
	/* Load RegisterPage */

	public RegistrationPage navigateToRegisterPage() {

		clickOnWebElement(registerLink);

		RegistrationPage registerpage = new RegistrationPage(driver);

		return registerpage;

	}

	
	/* Load DashboardPage */

	public DashboardPage NavigateToDashboardPage() {

		SendValue(enterUserName, "kiran@gmail.com");

		SendValue(enterPassword, "123456");

		clickOnWebElement(signInButton);

		DashboardPage dashboardpage = new DashboardPage(driver);

		return dashboardpage;

	}

}
