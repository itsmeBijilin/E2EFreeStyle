package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonActions.CommonActions;
import testSuite.BaseClass;

public class TC_05_ALGT_SeatsPage_P5 extends BasePage {
	@FindBy(xpath = "//*[@data-hook='seats-page_page-heading']")
	private WebElement seatsTxtValidation;

	@FindBy(xpath = "//*[text()='$']")
	private List<WebElement> availEconomySeats;

	@FindBy(xpath = "//*[@alt='star']")
	private List<WebElement> availlegRoomSeats;
	
	@FindBy(xpath = "//*[@class='SeatMap__Plane-sc-1vfc0qg-0 kmUvjz']//*[@class='Block-ml0umf-1 gvuLyD']//div[@class='Row-sc-83lwzk-0 hrswgB']//img[@alt='star']")
	private List<WebElement> economySeats;

	@FindBy(xpath = "//*[@data-hook='seats-page_continue']")
	private WebElement seatsContinueBtn;

	@FindBy(xpath = "//*[@data-hook='seats-page_continue']")
	private WebElement bonusContinue;

	@FindBy(xpath = "//*[@data-hook='seats-page_continue-popup']")
	private WebElement continueSeatsBundle;

	@FindBy(xpath = "(//*[@class='Text-sc-1o5ubbx-0 gRLrXA'])[1]")
	private WebElement bundleTxt;
	
	@FindBy(xpath = "//*[text()='Choose Returning Seats']")
	private WebElement chooseReturningSeats;
	
	@FindBy(xpath = "//*[@data-hook='seats-page_continue-popup']")
	private WebElement returnSeatContinue;

	public TC_05_ALGT_SeatsPage_P5(WebDriver driver) {
		super(driver);
	}

	public void seatPageTxtValidation() {
		new CommonActions().explicitWait(seatsTxtValidation, "Seats Txt Validation");
		System.out.println("Validated, In Seats page");
		BaseClass.logger.info("Validated, In Seats page");
	}

	public void seatSelection() throws Exception {
		try {
			int seatCount = availEconomySeats.size() + availlegRoomSeats.size();
			System.out.println(seatCount);

//			int index = new CommonActions().randomRangeRandom(0, availEconomySeats.size());
//			int index1 = new CommonActions().getRandomNumbers(1, availlegRoomSeats.size());
			
			int index = new CommonActions().randomRangeRandom(0, economySeats.size());
			int index1 = new CommonActions().getRandomNumbers(1, economySeats.size());

			Thread.sleep(2000);

			if (bundleTxt.getText().contains("Allegiant Bonus bundle")) {
				Thread.sleep(2000);
				System.out.println("*********INside Bonus Bundle*********");
				//availlegRoomSeats.get(index1).click();
				economySeats.get(index1).click();
				Thread.sleep(1000);
				economySeats.get(new CommonActions().getRandomNumbers(1, economySeats.size())).click();
				Thread.sleep(1000);
				new CommonActions().explicitWait(bonusContinue, "bonusContinue");
				new CommonActions().doClick(bonusContinue, "Seats Continue Button", bonusContinue);		
			} else if (bundleTxt.getText().contains("Allegiant Total bundle")) {
				Thread.sleep(2000);
				//availlegRoomSeats.get(index1).click();
				economySeats.get(index1).click();
				new CommonActions().explicitWait(seatsContinueBtn, "Seats Continue Button");
				Thread.sleep(2000);
				new CommonActions().doClick(seatsContinueBtn, "Seats Continue Button", seatsContinueBtn);
			} else if (!bundleTxt.getText().contains("Allegiant")) {
				if (availEconomySeats.size() != 0) {
					availEconomySeats.get(index).click();
					new CommonActions().explicitWait(seatsContinueBtn, "Seats Continue Button");
					new CommonActions().doClick(seatsContinueBtn, "Seats Continue Button", seatsContinueBtn);
				} else {
					availlegRoomSeats.get(index1).click();
					new CommonActions().explicitWait(seatsContinueBtn, "Seats Continue Button");
					new CommonActions().doClick(seatsContinueBtn, "Seats Continue Button", seatsContinueBtn);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void clickSeatContinueBtn() throws Exception {
		new CommonActions().explicitWait(seatsContinueBtn, "Seats Continue Button");
		// Thread.sleep(2000);
		new CommonActions().doClick(seatsContinueBtn, "Seats Continue Button", seatsContinueBtn);
	}
	
	public void seatSelectionReturn() throws Exception {
		try {
			new CommonActions().explicitWait(chooseReturningSeats, "Choose Returning Seats");
			
			int seatCount = availEconomySeats.size() + availlegRoomSeats.size();
			System.out.println(seatCount);

//			int index = new CommonActions().randomRangeRandom(0, availEconomySeats.size());
//			int index1 = new CommonActions().getRandomNumbers(1, availlegRoomSeats.size());
			
			int index = new CommonActions().randomRangeRandom(0, economySeats.size());
			int index1 = new CommonActions().getRandomNumbers(1, economySeats.size());

			Thread.sleep(2000);

			if (bundleTxt.getText().contains("Allegiant Bonus bundle")) {
				Thread.sleep(2000);
				//availlegRoomSeats.get(index1).click();
				economySeats.get(0).click();
				Thread.sleep(1000);
				economySeats.get(1).click();
				Thread.sleep(1000);
				new CommonActions().explicitWait(bonusContinue, "bonusContinue");
				new CommonActions().doClick(bonusContinue, "Seats Continue Button", bonusContinue);
//				new CommonActions().explicitWait(returnSeatContinue, "Return Seat Continue Button");
//				new CommonActions().doClick(returnSeatContinue, "Return Seat Continue", returnSeatContinue);
			} else if (bundleTxt.getText().contains("Allegiant Total bundle")) {
				Thread.sleep(2000);
				//availlegRoomSeats.get(index1).click();
				economySeats.get(index1).click();
				new CommonActions().explicitWait(seatsContinueBtn, "Seats Continue Button");
				Thread.sleep(2000);
				new CommonActions().doClick(seatsContinueBtn, "Seats Continue Button", seatsContinueBtn);
			} else if (!bundleTxt.getText().contains("Allegiant")) {
				if (availEconomySeats.size() != 0) {
					availEconomySeats.get(index).click();
					new CommonActions().explicitWait(seatsContinueBtn, "Seats Continue Button");
					new CommonActions().doClick(seatsContinueBtn, "Seats Continue Button", seatsContinueBtn);
				} else {
					availlegRoomSeats.get(index1).click();
					new CommonActions().explicitWait(seatsContinueBtn, "Seats Continue Button");
					new CommonActions().doClick(seatsContinueBtn, "Seats Continue Button", seatsContinueBtn);
				}
			}
		
		} catch (Exception e) {

		}
		
		
	}
}
