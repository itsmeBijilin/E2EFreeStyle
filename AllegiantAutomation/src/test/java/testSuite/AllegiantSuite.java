package testSuite;

import org.testng.annotations.Test;

import pageObjects.TC_01_ALGT_HomeObjects_P1;
import pageObjects.TC_02_ALGT_FlightsPage_P2;
import pageObjects.TC_03_ALGT_BundlesPage_P3;
import pageObjects.TC_04_ALGT_TravellersPage_P4;
import pageObjects.TC_05_ALGT_SeatsPage_P5;
import pageObjects.TC_06_ALGT_Bags_P6;
import pageObjects.TC_08_ALGT_Cars_P8;
import pageObjects.TC_09_ALGT_PaymentPopUp;

public class AllegiantSuite extends BaseClass {
	//@Test
	public void TC_01_HomePage() throws Exception {
		BaseClass.logger.info("************ Execution Started ***************");
		new TC_01_ALGT_HomeObjects_P1(driver).cookiePopUp();
		new TC_01_ALGT_HomeObjects_P1(driver).closePopUpCloseIcon();
		BaseClass.logger.info("************ Home Page ***************");
		
		new TC_01_ALGT_HomeObjects_P1(driver).clickOneWay();
		new TC_01_ALGT_HomeObjects_P1(driver).originClick_selection();
		new TC_01_ALGT_HomeObjects_P1(driver).destinationClick_Selection();
		new TC_01_ALGT_HomeObjects_P1(driver).clickDepartureDateField();
		new TC_01_ALGT_HomeObjects_P1(driver).selectingDate();
		new TC_01_ALGT_HomeObjects_P1(driver).clickTravellersField();
		new TC_01_ALGT_HomeObjects_P1(driver).clickSearchButton();
	
		BaseClass.logger.info("************ Flights Page ***************");
		new TC_02_ALGT_FlightsPage_P2(driver).selectFlights();
		new TC_02_ALGT_FlightsPage_P2(driver).clickFlightContinueBtn();
		new BaseClass().reportsLogs(getUserProperties("testName1"), "End of Flight page");
		
		BaseClass.logger.info("************ Bundles Page ***************");
		new TC_03_ALGT_BundlesPage_P3(driver).bundletxtValidation();
		new TC_03_ALGT_BundlesPage_P3(driver).selectBundle();
		new TC_03_ALGT_BundlesPage_P3(driver).clickBundleContinueBtn();
		new BaseClass().reportsLogs(getUserProperties("testName2"), "End of Bundles page");
	
		BaseClass.logger.info("************ Travelers page ***************");
		new TC_04_ALGT_TravellersPage_P4(driver).travellerPageTxtValidation();
		new TC_04_ALGT_TravellersPage_P4(driver).enterfirstLastName();
		new TC_04_ALGT_TravellersPage_P4(driver).selectMonth(getUserProperties("month"));
		new TC_04_ALGT_TravellersPage_P4(driver).selectDay(getUserProperties("date"));
		new TC_04_ALGT_TravellersPage_P4(driver).enterYear();
		new TC_04_ALGT_TravellersPage_P4(driver).enterMobileNumber();
		new TC_04_ALGT_TravellersPage_P4(driver).enterMailId();
		new TC_04_ALGT_TravellersPage_P4(driver).clickTravelerContinue();
		new BaseClass().reportsLogs(getUserProperties("testName3"), "End of Travelers page");

		BaseClass.logger.info("************ Seats Page***************");
		new TC_05_ALGT_SeatsPage_P5(driver).seatPageTxtValidation();
		new TC_05_ALGT_SeatsPage_P5(driver).seatSelection();
		new BaseClass().reportsLogs(getUserProperties("testName4"), "End of Seats page");

	
		BaseClass.logger.info("************ Bags Page ***************");
		new TC_06_ALGT_Bags_P6(driver).bagsTxtValidation();
		new TC_06_ALGT_Bags_P6(driver).addCheckedBags();
		new TC_06_ALGT_Bags_P6(driver).clickBagPageContinue();
		new BaseClass().reportsLogs(getUserProperties("testName5"), "End of Bags page");
		
		BaseClass.logger.info("************ Cars Page  ***************");
		new TC_08_ALGT_Cars_P8(driver).carTxtValidation();
		new TC_08_ALGT_Cars_P8(driver).selectCars();
		new TC_08_ALGT_Cars_P8(driver).clickCarContinueButton();
		new BaseClass().reportsLogs(getUserProperties("testName6"), "End of cars page");
	
		BaseClass.logger.info("************ Payment pop up page ***************");
		new TC_09_ALGT_PaymentPopUp(driver).closePaymentPopUp();
		new BaseClass().reportsLogs(getUserProperties("testName7"), "Closed payment popup");
	}
	
	@Test
	public void TC_02_RoundTrip() throws Exception {
		BaseClass.logger.info("************ Execution Started ***************");
		new TC_01_ALGT_HomeObjects_P1(driver).cookiePopUp();
		new TC_01_ALGT_HomeObjects_P1(driver).closePopUpCloseIcon();
		BaseClass.logger.info("************ Home Page ***************");
		
		new TC_01_ALGT_HomeObjects_P1(driver).originClick_selection();
		new TC_01_ALGT_HomeObjects_P1(driver).destinationClick_Selection();
		//new TC_01_ALGT_HomeObjects_P1(driver).clickSecondPopUp();
		new TC_01_ALGT_HomeObjects_P1(driver).closePopUpCloseIcon();
		new TC_01_ALGT_HomeObjects_P1(driver).clickDepartureDateField();
		new TC_01_ALGT_HomeObjects_P1(driver).selectingDate();
		new TC_01_ALGT_HomeObjects_P1(driver).returnDate();
		new TC_01_ALGT_HomeObjects_P1(driver).clickTravellersField();
		new TC_01_ALGT_HomeObjects_P1(driver).clickAdultIncrement();
		new TC_01_ALGT_HomeObjects_P1(driver).clickSearchButton();
	
		BaseClass.logger.info("************ Flights Page ***************");
		new TC_02_ALGT_FlightsPage_P2(driver).selectFlights();
		new TC_02_ALGT_FlightsPage_P2(driver).clickFlightContinueBtn();
		//new BaseClass().reportsLogs(getUserProperties("testName1"), "End of Flight page");
		
		BaseClass.logger.info("************ Bundles Page ***************");
		new TC_03_ALGT_BundlesPage_P3(driver).bundletxtValidation();
		new TC_03_ALGT_BundlesPage_P3(driver).selectBundle();
		new TC_03_ALGT_BundlesPage_P3(driver).clickBundleContinueBtn();
		//new BaseClass().reportsLogs(getUserProperties("testName2"), "End of Bundles page");
	
		BaseClass.logger.info("************ Travelers page ***************");
		new TC_04_ALGT_TravellersPage_P4(driver).travellerPageTxtValidation();
		new TC_04_ALGT_TravellersPage_P4(driver).enterfirstLastName();
		new TC_04_ALGT_TravellersPage_P4(driver).selectMonth(getUserProperties("month"));
		new TC_04_ALGT_TravellersPage_P4(driver).selectDay(getUserProperties("date"));
		new TC_04_ALGT_TravellersPage_P4(driver).enterYear();
		new TC_04_ALGT_TravellersPage_P4(driver).enterMobileNumber();
		new TC_04_ALGT_TravellersPage_P4(driver).enterMailId();
		
		new TC_04_ALGT_TravellersPage_P4(driver).enterTravelerTwofirstName();
		new TC_04_ALGT_TravellersPage_P4(driver).enterTravelerTwoLastName();
		new TC_04_ALGT_TravellersPage_P4(driver).selectingGender();
		new TC_04_ALGT_TravellersPage_P4(driver).selectMonth(getUserProperties("T2month"));
		new TC_04_ALGT_TravellersPage_P4(driver).selectDay(getUserProperties("T2date"));
		new TC_04_ALGT_TravellersPage_P4(driver).enterTravelerTwoYear();
		new TC_04_ALGT_TravellersPage_P4(driver).enterTravelerTwoMobNumber();
		new TC_04_ALGT_TravellersPage_P4(driver).enterTravelerTwoEmail();
		
		
		new TC_04_ALGT_TravellersPage_P4(driver).clickTravelerContinue();
		//new BaseClass().reportsLogs(getUserProperties("testName3"), "End of Travelers page");

		BaseClass.logger.info("************ Seats Page***************");
		new TC_05_ALGT_SeatsPage_P5(driver).seatPageTxtValidation();
		new TC_05_ALGT_SeatsPage_P5(driver).seatSelection();
		Thread.sleep(1000);
		new TC_05_ALGT_SeatsPage_P5(driver).seatSelectionReturn();
		//new BaseClass().reportsLogs(getUserProperties("testName4"), "End of Seats page");
		Thread.sleep(2000);
	
		BaseClass.logger.info("************ Bags Page ***************");
		new TC_06_ALGT_Bags_P6(driver).bagsTxtValidation();
		new TC_06_ALGT_Bags_P6(driver).clickIncrementCarryOnBag();
		new TC_06_ALGT_Bags_P6(driver).travellerTwoClickIncrementCarryOnBag();
		//new TC_06_ALGT_Bags_P6(driver).addCheckedBags();
		new TC_06_ALGT_Bags_P6(driver).clickBagPageContinue();
		//new BaseClass().reportsLogs(getUserProperties("testName5"), "End of Bags page");
		
		BaseClass.logger.info("************ Cars Page  ***************");
		new TC_08_ALGT_Cars_P8(driver).carTxtValidation();
		new TC_08_ALGT_Cars_P8(driver).selectCars();
		//new TC_08_ALGT_Cars_P8(driver).clickCarContinueButton();
		//new BaseClass().reportsLogs(getUserProperties("testName6"), "End of cars page");
	
		BaseClass.logger.info("************ Payment pop up page ***************");
		new TC_09_ALGT_PaymentPopUp(driver).closePaymentPopUp();
		Thread.sleep(2000);
		//new BaseClass().reportsLogs(getUserProperties("testName7"), "Closed payment popup");
	}
}
