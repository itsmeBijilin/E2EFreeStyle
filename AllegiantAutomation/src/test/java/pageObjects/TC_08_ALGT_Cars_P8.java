package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonActions.CommonActions;
import testSuite.BaseClass;

public class TC_08_ALGT_Cars_P8 extends BasePage {
	@FindBy(xpath = "//*[@data-hook='cars-page_page-heading']")
	private WebElement carTxtValidation;

	@FindBy(xpath = "//*[@class='Button__StyledButton-sc-1ececxa-1 chKEKf CarVendorPrices__PriceSelectionButton-ayz81e-3 kZTAAf']")
	private List<WebElement> availableCars;

	@FindBy(xpath = "//*[@data-hook='cars-page_continue']")
	private WebElement carContinueBtn;
	
	@FindBy(xpath = "(//*[@class='Button__StyledButton-sc-1ececxa-1 chKEKf CarVendorPrices__PriceSelectionButton-ayz81e-3 kZTAAf'])[1]")
	private WebElement carElement;

	public TC_08_ALGT_Cars_P8(WebDriver driver) {
		super(driver);
	}

	public void carTxtValidation() throws Exception {
		Thread.sleep(5000);
		new CommonActions().explicitWait(carTxtValidation,"Car Txt Validation");
		Thread.sleep(2000);
			System.out.println("Validated, In Cars page");
			BaseClass.logger.info("Validated, In Cars page");
		}

	public void selectCars() throws Exception {
		Thread.sleep(2000);
		int len = availableCars.size();
		if(len!=0) {
			availableCars.get(0).click();
			BaseClass.logger.info("Car is selected");
			
			new CommonActions().explicitWait(carContinueBtn, "Car Continue Button");
			new CommonActions().doClick(carContinueBtn, "car Continue Button", carContinueBtn);
		}
		else
			return;
		
	}

	public void clickCarContinueButton() {
		new CommonActions().explicitWait(carContinueBtn, "Car Continue Button");
		new CommonActions().doClick(carContinueBtn, "car Continue Button", carContinueBtn);
	}
}
