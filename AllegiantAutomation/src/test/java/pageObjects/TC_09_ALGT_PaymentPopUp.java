package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonActions.CommonActions;

public class TC_09_ALGT_PaymentPopUp extends BasePage {
	@FindBy(xpath = "//*[@data-hook='payment-page_ice-popup']//img[@alt='closeIcon']")
	private WebElement closePaymentPopup;
	
	@FindBy(xpath = "/html/body/div[8]/div/div/div/div/button/img")
	private WebElement closePopup;
	
	@FindBy(xpath = "//*[@class='Popup__CloseIcon-sc-1r32d3w-2 frpEuh']")
	private WebElement close;
	
	

	public TC_09_ALGT_PaymentPopUp(WebDriver driver) {
		super(driver);
	}

	public void closePaymentPopUp() throws Exception {
		new CommonActions().explicitWait(closePaymentPopup, "Close Payment Popup");
		new CommonActions().doClick(closePaymentPopup, "Close Payment Popup", closePaymentPopup);
	}
}
