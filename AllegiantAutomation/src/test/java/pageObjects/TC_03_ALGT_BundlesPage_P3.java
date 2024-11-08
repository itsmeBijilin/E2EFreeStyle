package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonActions.CommonActions;
import testSuite.BaseClass;

public class TC_03_ALGT_BundlesPage_P3 extends BasePage {
	@FindBy(xpath = "//*[@class='Text-sc-1o5ubbx-0 jNEDDE']")
	private WebElement bundletxtValidation;

	@FindBy(xpath = "//*[text()='SELECT']")
	private List<WebElement> availableBundles;

	@FindBy(xpath = "//*[@class='Button__StyledButton-sc-1ececxa-1 jGMNve PageFooter__ContinueButton-sc-12arybe-1 hsqGDw']")
	private WebElement BundleContinueBtn;

	public TC_03_ALGT_BundlesPage_P3(WebDriver driver) {
		super(driver);
	}

	public void bundletxtValidation() throws Exception {
		new CommonActions().explicitWait(bundletxtValidation, "Bundle txt Validation ");
		Thread.sleep(2000);
		System.out.println("Validated, In Bundles page");
		BaseClass.logger.info("Validated, In Bundles page");
	}

	public void selectBundle() throws Exception {
		Thread.sleep(3000);
		List<WebElement> availBundles = new ArrayList<WebElement>();
		System.out.println(availableBundles.size());
		for (WebElement webElement : availBundles) {
			System.out.println(webElement.getText());
		}
		int num = new CommonActions().getRandomNumbers(0, availableBundles.size());
		// System.out.println("**" + num);
		availableBundles.get(1).click();
		BaseClass.logger.info("Allegiant Bonus Bundle is selected");
	}

	public void clickBundleContinueBtn() {
		new CommonActions().explicitWait(BundleContinueBtn, "Bundle Continue Button");
		new CommonActions().doClick(BundleContinueBtn, "Bundle Continue Button", BundleContinueBtn);
	}
}
