package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonActions.CommonActions;
import testSuite.BaseClass;

public class TC_04_ALGT_TravellersPage_P4 extends BasePage {
	@FindBy(xpath = "//*[@class='Text-sc-1o5ubbx-0 jNEDDE']")
	private WebElement travellerPageTxtValidation;

	@FindBy(name = "adults.0.first-name")
	private WebElement firstNameTxtBox;

	@FindBy(name = "adults.0.last-name")
	private WebElement lastNameTxtBox;

//	@FindBy(xpath = "(//*[@class='Radio__IconContainer-owm0zi-0 fIAozG'])[1]")
//	private WebElement genderRadioBox;

	@FindBy(xpath = "//*[text()='Male']")
	private WebElement male;

	@FindBy(xpath = "(//*[text()='Month'])[1]")
	private WebElement dateofMonthDropdown;

	@FindBy(xpath = "//*[@class=' css-11unzgr']//div[@data-hook]//div")
	private List<WebElement> allMonths;

	@FindBy(xpath = "(//*[text()='Day'])[1]")
	private WebElement dayDropDown;

	@FindBy(xpath = "//*[@class=' css-11unzgr']//div[@data-hook]//div")
	private List<WebElement> allDays;

	@FindBy(xpath = "(//*[@placeholder='Year'])[1]")
	private WebElement yearFieldBox;

	@FindBy(name = "adults.0.primary-phone-number")
	private WebElement mobileNumFieldBox;

	@FindBy(name = "adults.0.email")
	private WebElement mailFieldBox;

	@FindBy(xpath = "//*[@class='Button__StyledButton-sc-1ececxa-1 jGMNve PageFooter__ContinueButton-sc-12arybe-1 hsqGDw']")
	private WebElement travellersContinueBtn;
	
	/* Traveler Two */
	@FindBy(xpath = "//*[@data-hook='traveler_1']//input[@id='adults.1.first-name']")
	private WebElement travellerTwoName;
	
	@FindBy(xpath = "//*[@data-hook='traveler_1']//input[@id='adults.1.last-name']")
	private WebElement travellerTwoLastName;
	
	@FindBy(xpath = "(//*[text()='Male'])[2]")
	private WebElement travellerTwoGender;
	
	@FindBy(xpath = "(//*[text()='Month'])[2]")
	private WebElement travellerTwoMonth;
	
	@FindBy(xpath = "(//*[text()='Day'])[2]")
	private WebElement travellerTwodayDropDown;
	
	@FindBy(xpath = "(//*[@placeholder='Year'])[2]")
	private WebElement travelerTwoyearFieldBox;
	
	@FindBy(name = "adults.1.primary-phone-number")
	private WebElement travellerTwoMobileNumberField;
	
	@FindBy(name="adults.1.email")
	private WebElement travllerTwoEmailField;

	public TC_04_ALGT_TravellersPage_P4(WebDriver driver) {
		super(driver);
	}

	public void travellerPageTxtValidation() throws Exception {
		new CommonActions().explicitWait(travellerPageTxtValidation, "Traveller Page Txt Validation");
		Thread.sleep(2000);
		System.out.println("Validated, In Traveler page");
		BaseClass.logger.info("Validated, In Traveler page");
	}

	public void enterfirstLastName() {
		try {
			new CommonActions().explicitWait(firstNameTxtBox, "First Name Txt Box");
			Thread.sleep(2000);
			new CommonActions().doClick(firstNameTxtBox, "First Name Text Box", firstNameTxtBox);
			new CommonActions().doSendKeys(firstNameTxtBox, new CommonActions().getUserProperties("firstName"));

			new CommonActions().explicitWait(lastNameTxtBox, "Last Name Txt Box");
			Thread.sleep(1000);
			new CommonActions().doClick(lastNameTxtBox, "Last Name Text Box", lastNameTxtBox);
			new CommonActions().doSendKeys(lastNameTxtBox, new CommonActions().getUserProperties("lastName"));
			new CommonActions().explicitWait(male, "Male Radio box");
			// new CommonActions().toScrollToElement(genderRadioBox);
			new CommonActions().doClick(male, "male gender Radio Box", male);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	public void selectMonth(String input) throws Exception {
		new CommonActions().explicitWait(dateofMonthDropdown, "Date of Month Dropdown");
		new CommonActions().doClick(dateofMonthDropdown, "Date of Month Dropdown", dateofMonthDropdown);
		Thread.sleep(2000);
		// List<WebElement> monthsAvail = new ArrayList<>();
		for (WebElement webElement : allMonths) {
			String getTxt = webElement.getText();
			// System.out.println(getTxt);
			if (getTxt.equalsIgnoreCase(input)) {
				webElement.click();
				break;
			}
		}
	}

	public void selectDay(String input) throws Exception {
		new CommonActions().doClick(dayDropDown, "Day Drop Down", dayDropDown);
		Thread.sleep(2000);
		// List<WebElement> daysAvail = new ArrayList<>();
		for (WebElement webElement : allDays) {
			String getTxt = webElement.getText();
			if (getTxt.equalsIgnoreCase(input)) {
				webElement.click();
				break;
			}
		}
	}

	public void enterYear() throws Exception {
		new CommonActions().explicitWait(yearFieldBox, "Year Field Box");
		new CommonActions().doSendKeys(yearFieldBox, new CommonActions().getUserProperties("year"));
	}

	public void enterMobileNumber() throws Exception {
		new CommonActions().doSendKeys(mobileNumFieldBox, new CommonActions().getUserProperties("mobileNumber"));
	}

	public void enterMailId() throws Exception {
		new CommonActions().doSendKeys(mailFieldBox, new CommonActions().getUserProperties("email"));
	}

	public void clickTravelerContinue() {
		new CommonActions().explicitWait(travellersContinueBtn, "Travellers Continue Button");
		new CommonActions().doClick(travellersContinueBtn, "Travellers Continue Button", travellersContinueBtn);
	}
	
	public void enterTravelerTwofirstName() throws Exception {
		new CommonActions().explicitWait(travellerTwoName, "Traveller two first name");
		new CommonActions().doSendKeys(travellerTwoName, new CommonActions().getUserProperties("T2firstName"));
	}
	
	public void enterTravelerTwoLastName() throws Exception {
		new CommonActions().explicitWait(travellerTwoLastName, "Traveller two Last name");
		new CommonActions().doSendKeys(travellerTwoLastName, new CommonActions().getUserProperties("T2lastName"));
	}
	
	public void selectingGender() throws Exception {
		new CommonActions().explicitWait(travellerTwoGender, "Traveller Two Gender");
		Thread.sleep(2000);
		new CommonActions().doClick(travellerTwoGender, "Gender Selection", travellerTwoGender);
	}
	
	public void enterTravelerTwoYear() throws Exception {
		new CommonActions().explicitWait(travelerTwoyearFieldBox, "Traveler Two year Field Box");
		new CommonActions().doSendKeys(travelerTwoyearFieldBox, new CommonActions().getUserProperties("T2year"));
	}
	
	public void enterTravelerTwoMobNumber() throws Exception {
		new CommonActions().explicitWait(travellerTwoMobileNumberField, "Traveler Two Mobile Number Field Box");
		new CommonActions().doSendKeys(travellerTwoMobileNumberField, new CommonActions().getUserProperties("T2mobileNumber"));
	}
	
	public void enterTravelerTwoEmail() throws Exception {
		new CommonActions().explicitWait(travllerTwoEmailField, "Traveler Two Email Field Box");
		new CommonActions().doSendKeys(travllerTwoEmailField, new CommonActions().getUserProperties("T2email"));
	}
	
}
