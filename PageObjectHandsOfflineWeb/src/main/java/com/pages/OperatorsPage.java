package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import com.base.BasePage;
import com.repo.OperatorsPageRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OperatorsPage extends OperatorsPageRepo {

	public WebDriver driver = null;

	public OperatorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*************************** Operators Page Methods ***************************/

	/* Method Number 01 */

	public boolean checkOperatorsListTableData() throws Exception {

		ArrayList<String> actList = new ArrayList<String>();
		
		ArrayList<String> expList = BasePage.readExcelSheetDataUsingArraylist("OfflineWebSiteData.xlsx",
				"operatortabledata");
				
		for (int i = 0; i < operatorTableData.size(); i++) {

			String value = operatorTableData.get(i).getText();

			actList.add(value);

		}
		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Operators table data matches with as expected.");

			return true;

		} else {

			log.info("Operators table data doesn't matches with as expected.");

			return false;

		}
	}
	

	/* Method Number 02 */

	public boolean checkWayToConnectWithoutWhatAppOnlyToOperators() throws Exception {

		HashMap<String, String> actMap = new HashMap<String, String>();
		
		HashMap<String, String> expMap = new HashMap<String, String>();

		ArrayList<String> expvalue = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"operatortabledata", 3);
		ArrayList<String> expkey = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"operatortabledata", 1);

		for (int i = 0; i < wayToConnect.size(); i++) {

			String key = operatorsName.get(i).getText();
			String value = wayToConnect.get(i).getText();

			if (value.contains("Phone Call")) {

				actMap.put(key, value);
			}
		}
		
		expMap.put(expkey.get(1), expvalue.get(1));
		expMap.put(expkey.get(2), expvalue.get(2));
		expMap.put(expkey.get(3), expvalue.get(3));

		log.info("Actual Map : " + actMap);
		log.info("Expected Map : " + expMap);

		if (actMap.equals(expMap)) {

			log.info("Operators name and way to connect them by without whatsapp matches with as expected.");

			return true;

		} else {

			log.info("Operators name and way to connect them by without whatsapp doesn't matches with as expected.");

			return false;

		}
	}

	
	/* Method Number 03 */

	public boolean checkWayToConnectWithWhatAppOnlyToOperators() throws Exception {

		HashMap<String, String> actList = new HashMap<String, String>();
		HashMap<String, String> expList = new HashMap<String, String>();

		ArrayList<String> expkey = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"operatortabledata", 1);
		
		ArrayList<String> expvalue = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"operatortabledata", 3);

		for (int i = 0; i < wayToConnect.size(); i++) {

			String value = wayToConnect.get(i).getText();
			String key = operatorsName.get(i).getText();

			if (value.contains("Whats App Only")) {

				actList.put(key, value);
			}
		}
		expList.put(expkey.get(0), expvalue.get(0));
		expList.put(expkey.get(4), expvalue.get(4));

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Operators name and way to connect them by whatsapp only matches with as expected.");

			return true;

		} else {

			log.info("Operators name and way to connect them by whatsapp only doesn't matches with as expected.");

			return false;

		}
	}
	

	/* Method Number 04 */

	public boolean checkTechnicalPersonFromOperatorsListTable() throws Exception {

		LinkedHashMap<String, String> actList = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> expList = new LinkedHashMap<String, String>();

		ArrayList<String> expkey = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"operatortabledata", 1);
		
		ArrayList<String> expvalue = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"operatortabledata", 2);

		for (int i = 0; i < operatorsCourse.size(); i++) {

			String key = operatorsName.get(i).getText();
			
			String value = operatorsCourse.get(i).getText();

			if (value.contains("Technical")) {

				actList.put(key, value);
			}
		}
		expList.put(expkey.get(0), expvalue.get(0));

		expList.put(expkey.get(1), expvalue.get(1));

		expList.put(expkey.get(4), expvalue.get(4));

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Operators name and their Technical courses matches with as expected.");

			return true;

		} else {

			log.info("Operators name and their Technical courses doesn't matches with as expected.");

			return false;

		}
	}
	

	/* Method Number 05 */

	public boolean checkTimingOnMondayOfOperators() throws Exception {

		HashMap<String, String> actList = new HashMap<String, String>();
		HashMap<String, String> expList = new HashMap<String, String>();

		ArrayList<String> expkey = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"operatortabledata", 1);
		
		ArrayList<String> expvalue = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"operatortabledata", 5);

		for (int i = 0; i < timingOfOperator.size(); i++) {

			String key = operatorsName.get(i).getText();
			String value = timingOfOperator.get(i).getText();

			if (value.contains("Monday")) {

				actList.put(key, value);
			}
		}
		expList.put(expkey.get(0), expvalue.get(0));

		expList.put(expkey.get(1), expvalue.get(1));

		expList.put(expkey.get(2), expvalue.get(2));

		expList.put(expkey.get(3), expvalue.get(3));

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );
		
		if (actList.equals(expList)) {

			log.info("Operators name and their Monday timing matches with as expected.");

			return true;

		} else {

			log.info("Operators name and their Monday timing doesn't matches with as expected.");

			return false;

		}
	}

	
	/* Method Number 06 */

	public boolean checkMobileNumberOfPersonFromOperatorsListTable() throws Exception {

		HashMap<String, String> actList = new HashMap<String, String>();

		HashMap<String, String> expList = BasePage
				.readSpecificExcelSheetDataUsingHashMap("OfflineWebSiteData.xlsx","operatortabledata", 1, 4);
		
		for (int i = 0; i < contactNumberOfOperator.size(); i++) {

			String value = contactNumberOfOperator.get(i).getText();

			String key = operatorsName.get(i).getText();

			if (value.length() == 10) {

				actList.put(key, value);
			}
		}

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Operators name and their mobile number matches with as expected.");

			return true;

		} else {

			log.info("Operators name and their mobile number doesn't matches with as expected.");

			return false;
		}

	}

	
	/* Method Number 07 */

	public boolean checkTimingOfOperators() throws Exception {

		HashMap<String, String> actList = new HashMap<String, String>();
		HashMap<String, String> expList = new HashMap<String, String>();

		ArrayList<String> expvalue = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"operatortabledata", 5);
		ArrayList<String> expkey = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"operatortabledata", 1);

		for (int i = 0; i < timingOfOperator.size(); i++) {

			String value = timingOfOperator.get(i).getText();

			String key = operatorsName.get(i).getText();

			if (value.contains("09:00 AM to 06:00 PM ")) {

				actList.put(key, value);

			}
		}

		expList.put(expkey.get(1), expvalue.get(1));

		expList.put(expkey.get(2), expvalue.get(2));

		expList.put(expkey.get(3), expvalue.get(3));

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Operators name and their timing matches with as expected.");

			return true;

		} else {

			log.info("Operators name and their timing doesn't matches with as expected.");

			return false;
		}

	}

}
