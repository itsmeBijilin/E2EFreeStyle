package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonActions.CommonActions;
import testSuite.BaseClass;

public class TC_02_ALGT_FlightsPage_P2 extends BasePage {
	@FindBy(xpath = "//*[@class='Text-sc-1o5ubbx-0 jNEDDE']")
	private WebElement flightPageValidation;

	@FindBy(xpath = "//*[@class='Text-sc-1o5ubbx-0 Price__StyledText-sc-2esdwy-1 fwsaUs']")
	private List<WebElement> availableFlightsPrice;

	@FindBy(xpath = "//*[@class='Button__StyledButton-sc-1ececxa-1 jGMNve PageFooter__ContinueButton-sc-12arybe-1 hsqGDw']")
	private WebElement flightsContinueBtn;

	public TC_02_ALGT_FlightsPage_P2(WebDriver driver) {
		super(driver);
	}

	public void validationFlightsPage() throws InterruptedException {
		new CommonActions().explicitWait(flightPageValidation, "Flight Page Validation");
		Thread.sleep(2000);
		if (flightPageValidation.getText().contains("Flights")) {
			System.out.println("Validated, In flights page");
			BaseClass.logger.info("Validated, In flights page");
		} else {
			System.err.println("Validated, In flights page");
			BaseClass.logger.error("Validated, In flights page");
		}
	}

	public void selectFlights() throws Exception {
		Thread.sleep(3000);
		List<WebElement> availFlights = new ArrayList<WebElement>();
		// System.out.println(availableFlightsPrice.size());
		for (WebElement webElement : availFlights) {
			System.out.println(webElement.getText());
		}
		int num = new CommonActions().randomRangeRandom(0, availFlights.size());
		// System.out.println("**"+num);
		availableFlightsPrice.get(num).click();
	}

	public void clickFlightContinueBtn() {
		new CommonActions().explicitWait(flightsContinueBtn, "Flights Continue Button");
		new CommonActions().doClick(flightsContinueBtn, "flights Continue Button", flightPageValidation);
	}
}
