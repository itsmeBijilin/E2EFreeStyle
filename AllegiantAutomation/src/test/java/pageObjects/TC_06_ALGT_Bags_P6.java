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
}