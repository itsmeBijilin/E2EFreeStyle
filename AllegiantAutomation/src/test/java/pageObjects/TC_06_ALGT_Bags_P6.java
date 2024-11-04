package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonActions.CommonActions;
import testSuite.BaseClass;

public class TC_06_ALGT_Bags_P6 extends BasePage {
	@FindBy(xpath = "//*[@data-hook='ancillaries-page_page-heading']")
	private WebElement bagsTxtValidation;

	@FindBy(xpath = "//*[@data-hook='ancillaries-page-traveler_0_checked-in_increment']")
	private WebElement addCheckBoxIcon;

	@FindBy(xpath = "//*[@data-hook='ancillaries-page_continue']")
	private WebElement bagsPageContinueBuuton;
	
	@FindBy(xpath = "//*[@data-hook='ancillaries-page-traveler_0_carry-on_increment']")
	private WebElement carryOnIncrementBtn;
	
	@FindBy(xpath = "//*[@data-hook='ancillaries-page-traveler_1_carry-on_increment']")
	private WebElement travellerTwoCarryOnIncrement;

	public TC_06_ALGT_Bags_P6(WebDriver driver) {
		super(driver);
	}

	public void bagsTxtValidation() throws Exception {
		new CommonActions().explicitWait(bagsTxtValidation, "Bags Txt Validation");
		BaseClass.logger.info("Validated, In Bags page");
	}

	public void addCheckedBags() throws Exception {
		new CommonActions().explicitWait(addCheckBoxIcon, "Add Check Box Icon");
		Thread.sleep(1000);
		new CommonActions().doClick(addCheckBoxIcon, "Add Check Box Icon", addCheckBoxIcon);
	}

	public void clickBagPageContinue() {
		new CommonActions().explicitWait(bagsPageContinueBuuton, "Bags Page Continue Buuton");
		new CommonActions().doClick(bagsPageContinueBuuton, "Bags Page Continue Button", bagsPageContinueBuuton);
	}
	
	public void clickIncrementCarryOnBag() {
		for(int i=0;i<1;i++) {
			new CommonActions().explicitWait(carryOnIncrementBtn, "Carry On Increment Button");
			new CommonActions().doClick(carryOnIncrementBtn, "Carry On Increment Button", carryOnIncrementBtn);
		}
	}
	
	public void travellerTwoClickIncrementCarryOnBag() {
		for(int i=0;i<1;i++) {
			new CommonActions().explicitWait(travellerTwoCarryOnIncrement, "Traveller Two Carry On Increment");
			new CommonActions().doClick(travellerTwoCarryOnIncrement, "Traveller Two Carry On Increment", travellerTwoCarryOnIncrement);
		}
	}
}
