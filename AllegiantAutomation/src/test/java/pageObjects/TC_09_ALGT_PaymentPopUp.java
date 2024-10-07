package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonActions.CommonActions;

public class TC_09_ALGT_PaymentPopUp extends BasePage {
	@FindBy(xpath = "//*[@data-hook='payment-page_ice-popup_close']//img[@alt='closeIcon']")
	private WebElement closePaymentPopup;

	public TC_09_ALGT_PaymentPopUp(WebDriver driver) {
		super(driver);
	}

	public void closePaymentPopUp() throws Exception {
		new CommonActions().explicitWait(closePaymentPopup, "Close Payment Popup");
		Thread.sleep(2000);
		new CommonActions().doClick(closePaymentPopup, "Close Payment Popup", closePaymentPopup);
	}
}
