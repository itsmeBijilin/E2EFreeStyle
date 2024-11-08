package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonActions.CommonActions;
import testSuite.BaseClass;

public class TC_01_ALGT_HomeObjects_P1 extends BasePage {
	@FindBy(xpath = "//*[@data-hook='overlay-merchandise_ice-pop_close']//img[@alt='closeIcon']")
	private WebElement popUpcloseIcon;

	@FindBy(xpath = "//*[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
	private WebElement cookiePopup;

	@FindBy(xpath = "//*[@class='Box-s8oj9r-0 eQqpHg']//div//img[@alt]")
	private WebElement popUp;

	@FindBy(xpath = "(//*[@class='Radio__IconContainer-owm0zi-0 fIAozG'])[2]")
	private WebElement oneWay;

	@FindBy(xpath = "//*[@class=' css-2b097c-container']//div[@data-hook='flight-search-origin']")
	private WebElement flightOriginSearch;

	@FindBy(xpath = "(//*[@class=' css-7udyxf'])[2]//div/following-sibling::div")
	private List<WebElement> availableOriginPlaces;

	@FindBy(xpath = "//*[@class=' css-2b097c-container']//div[@data-hook='flight-search-destination']")
	private WebElement destinationOriginSearch;

	@FindBy(xpath = "(//*[@class=' css-7udyxf'])[2]//div/following-sibling::div")
	private List<WebElement> availableDestinationPlaces;

	@FindBy(xpath = "//*[@class='Input__IconContainer-dn8eno-0 bVAduy']//button[@class='DatePicker__DateFieldControl-iz35q0-0 gecfVU']")
	private WebElement departureDateField;

	@FindBy(xpath = "(//*[@class='Box-s8oj9r-0 dLFASS'])[2]//div[@class='Box-s8oj9r-0 iSygsH']//div[@class='Calendar__Grid-epvxa4-0 Calendar__DateGrid-epvxa4-3 gNEFIj']//button[@aria-label]")
	private List<WebElement> availableDatesForBothMonths;

	@FindBy(xpath = "//*[@class='Expando__Label-sc-1am1gqe-0 diqXdw']//button[@data-hook='flight-search-travelers-expando-button']")
	private WebElement travellersField;

	@FindBy(xpath = "(//*[@aria-controls='adults'])[2]")
	private WebElement adultIncrementButton;

	@FindBy(xpath = "//*[@class='FlightSearchForm__GAClickEventTracker-lmu5bc-1 cmHRyO']//button[@data-hook='flight-search-submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//*[@data-hook='overlay-merchandise_ice-pop_close']//img[@alt='closeIcon']")
	private WebElement secondPopUp;
	
	@FindBy(xpath = "//*[@alt='Still dreaming of your next getaway? Sunseeker Resort Charlotte Harbor, southwest Florida']")
	private WebElement popUpOuter;

	public TC_01_ALGT_HomeObjects_P1(WebDriver driver) {
		super(driver);
	}

	public void cookiePopUp() {
		new CommonActions().explicitWait(cookiePopup, "cookiePopup");
		new CommonActions().doClick(cookiePopup, "Cookie Pop up", cookiePopup);
	}

	public void closePopUpCloseIcon() {
		new CommonActions().explicitWait(popUp, "Home pop Up");
		new CommonActions().doClick(popUpcloseIcon, "popUpcloseIcon", popUpcloseIcon);
	}

	public void clickOneWay() {
		new CommonActions().explicitWait(oneWay, "One way");
		new CommonActions().doClick(oneWay, "One way", oneWay);
	}

	public void originClick_selection() throws Exception {
		new CommonActions().doClick(flightOriginSearch, "flightOriginSearch", flightOriginSearch);
		Thread.sleep(2000);
		new CommonActions().toSelectRequiredCity(availableOriginPlaces,new CommonActions().getUserProperties("origin"));
		BaseClass.logger.info(new CommonActions().getUserProperties("origin")+" is passed in origin field");
	}

	public void destinationClick_Selection() throws Exception {
		new CommonActions().doClick(destinationOriginSearch, "destination Origin Search", destinationOriginSearch);
		Thread.sleep(2000);
		new CommonActions().toSelectRequiredCity(availableDestinationPlaces,new CommonActions().getUserProperties("destination"));
		BaseClass.logger.info(new CommonActions().getUserProperties("destination")+" is passed in destination field");
	}

	public void clickDepartureDateField() throws Exception {
		Thread.sleep(2000);
		new CommonActions().explicitWait(departureDateField, "Departure Date Field");
		new CommonActions().doClick(departureDateField, "departureDateField", departureDateField);
	}

	public void selectingDate() {
		List<WebElement> reqDates = new ArrayList<WebElement>();
		for (WebElement availDates : availableDatesForBothMonths) {
			String d = availDates.getText();
			String b = availDates.getAttribute("disabled");
			String c = availDates.getAttribute("aria-hidden");
			if (b == null) {
				if (d.isEmpty() == false) {
					reqDates.add(availDates);
				}
			}
		}
		reqDates.get(0).click();
	}
	
	public void returnDate() throws Exception {
		List<WebElement> reqDates = new ArrayList<WebElement>();
		for (WebElement availDates : availableDatesForBothMonths) {
			String d = availDates.getText();
			String b = availDates.getAttribute("disabled");
			String c = availDates.getAttribute("aria-hidden");
			if (b == null) {
				if (d.isEmpty() == false) {
					reqDates.add(availDates);
				}
			}
		}
		Thread.sleep(1000);
		reqDates.get(reqDates.size()-1).click();
	}

	public void clickTravellersField() {
		new CommonActions().explicitWait(travellersField, "Travellers Field");
		new CommonActions().doClick(travellersField, "Travellers Field", travellersField);
	}

	public void clickAdultIncrement() {
		new CommonActions().explicitWait(adultIncrementButton, "Adult Increment Button");
		new CommonActions().doClick(adultIncrementButton, "Adult Increment Button", adultIncrementButton);
	}

	public void clickSearchButton() {
		new CommonActions().explicitWait(searchButton, "Search Button");
		new CommonActions().doClick(searchButton, "Search Button", searchButton);
	}
	
	public void clickSecondPopUp() throws Exception {
		new CommonActions().explicitWait(popUpOuter, "Pop Up Outer");
		new CommonActions().doClick(secondPopUp, "Second Pop Up", secondPopUp);
	}
}
