package topic_07_ex_iframe_frame_window;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testscript_02_handleWindow {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
	}

	@Test
	public void testScript_02() {
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Get current Windown ( parent Window(
		String parentWindow1 = driver.getWindowHandle();

		// Move to element and click on it
		moveToElementByJS(OPEN_WINDOW_BUTTON);
		click(OPEN_WINDOW_BUTTON);

		// Switch to Google Window
		Set<String> getAllWindows = driver.getWindowHandles();
		for (String currentWin : getAllWindows) {
			if (!currentWin.equals(parentWindow1)) {
				driver.switchTo().window(currentWin);
				break;
			}
		}

		// Verify title of current Windown after switch
		String titleCurrentWin = driver.getTitle();
		Assert.assertEquals(titleCurrentWin, "Google");
		System.out.println("Title of Page : " + titleCurrentWin);

		// close windown
		driver.close();

		// switch to parent window
		driver.switchTo().window(parentWindow1);
		String titleParentWin = driver.getTitle();
		Assert.assertEquals(titleParentWin, "SELENIUM WEBDRIVER FORM DEMO");
		System.out.println("Title of Page : " + titleParentWin);

	}

	@Test
	public void testScript_03() {
		driver.get("http://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String parentWindow2 = driver.getWindowHandle();

		// Step 02 : If iframe appears, click to close
		List<WebElement> iframe4 = driver.findElements(By.xpath(IFRAME_4));

		// Step 02 : If iframe appears, click to close
		if (iframe4.size() > 0) {
			driver.switchTo().frame(iframe4.get(0));
			click(CLOSE_IFRAME4);
		}

		// Step 03 : click to Agril and Switch to new window
		click(AGRIL_BUTTON);
		switchToWindowByTitle(AGRIL_E_KENDRA_TITLE);

		// Step 04 : click to Account detail and switch
		click(ACCOUNT_DETAIL_BUTTON);
		switchToWindowByTitle(ACCOUNT_NET_BANKING_TITLE);

		// Step 05 : Switch to POLICY frame and switch to this frame
		switchToFrame(FRAME_FOOTER);
		click(POLICY_BUTTON);

		// Step 06 : Click to CSR and switch to new window
		switchToWindowByTitle(LEADING_BANK_TITLE);
		click(CRS_BUTTON);
		
		//Step 07 : close all windown without Parent Page
		closeAllWindowWithoutParentWin(parentWindow2);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void click(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void moveToElementByJS(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String item : allWindows) {
			System.out.println(item);
		}
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			System.out.println(currentWin);
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void switchToFrame(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public boolean closeAllWindowWithoutParentWin(String parentWindow) {
		Set<String> allHandleWinDows = driver.getWindowHandles();
		for (String currentWinDow : allHandleWinDows) {
			if (!currentWinDow.equals(parentWindow)) {
				driver.switchTo().window(currentWinDow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1) {
			System.out.println("Current Window : "+ driver.getTitle());
			return true;
		} else {
			return false;
		}

	}

	String OPEN_WINDOW_BUTTON = "//label[@for='open window']//following-sibling::a";

	String IFRAME_4 = "//iframe[@id='vizury-notification-template']";
	String CLOSE_IFRAME4 = "//div[@id='div-close']";

	String AGRIL_BUTTON = "//div[@class='sectionnav']//a[contains(.,'Agri')]";
	String AGRIL_E_KENDRA_TITLE = "HDFC Bank Kisan Dhan Vikas e-Kendra";

	String ACCOUNT_DETAIL_BUTTON = "//a[contains(@href,'netbanking')]";
	String ACCOUNT_NET_BANKING_TITLE = "Welcome to HDFC Bank NetBanking";

	String FRAME_FOOTER = "//frame[@name='footer']";
	String POLICY_BUTTON = "//a[contains(.,'Privacy Policy')]";

	String LEADING_BANK_TITLE = "HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan";
	String CRS_BUTTON = "//a[contains(.,'CSR')]";
}
