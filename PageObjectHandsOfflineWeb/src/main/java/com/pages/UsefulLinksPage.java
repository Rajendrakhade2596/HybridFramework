package com.pages;

import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;
import com.repo.UsefulLinksPageRepo;

public class UsefulLinksPage extends UsefulLinksPageRepo {

	WebDriver driver = null;

	public UsefulLinksPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	/**************************** UsefulLinks Page Methods***************************/

	/* Method Number 01 */

	public boolean checkUsefulLinksTableData() throws Exception {
		
		ArrayList<String> actList = new ArrayList<String>();
		
		ArrayList<String> expList = BasePage
				.readExcelSheetDataUsingArraylist("OfflineWebSiteData.xlsx","usefulLinkData");

		for (WebElement data : usefulLinkTableData) {

			String value = data.getText();

			actList.add(value);
		}

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Useful links table data matches with as expected.");

			return true;

		} else {

			log.info("Useful links table data doesn't matches with as expected.");

			return false;

		}
	}

	/* Method Number 02 */

	public boolean checkContentLinkOfUsefulLinksPage() throws Exception {
		
		ArrayList<String> actList = new ArrayList<String>();
		
		ArrayList<String> expList = BasePage
				.readExcelSheetDataUsingArraylist("OfflineWebSiteData.xlsx","UsefullinkWindow");

		String mainWindow = driver.getWindowHandle();

		for (int i = 0; i < contentLink.size(); i++) {

			contentLink.get(i).click();

		}

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			if (!(handle.equals(mainWindow))) {
				
				Thread.sleep(3000);
				
				driver.switchTo().window(handle);

				String value = driver.switchTo().window(handle).getTitle();

				actList.add(value);

				Thread.sleep(3000);

				driver.switchTo().window(handle).close();

			}

		}

		driver.switchTo().window(mainWindow);

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Content links after clicking all window title matches with as expected.");

			return true;

		} else {

			log.info("Content links after clicking all window title doesn't matches with as expected.");

			return false;

		}
	}

}
