package topic_10_wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScript_10_ex_Wait {
	
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		openBrowser("firefox", urlTestScript01);
		wait = new WebDriverWait(driver, 20);
	}

	@Test
	public void testScript_01_ImplicityWait() throws InterruptedException {
		
		// Step 02 : click Start button
		click(START_BUTTON);

		// Step 03 : verify Hello word is displayed
		Assert.assertTrue(driver.findElement(By.xpath(HELLO_WORD_TEXT)).isDisplayed());

		// Step 04 : verify text correct
		Assert.assertEquals(driver.findElement(By.xpath(HELLO_WORD_TEXT)).getText(), "Hello World!");
		System.out.println(driver.findElement(By.xpath(HELLO_WORD_TEXT)).getText());
		
		driver.quit();
	}

	@Test
	public void testScript_02_ExpilicityWai() throws InterruptedException {
		// Step 01 : open web
		driver.get(urlTestScript02);

		// Step 02 : wait element Date time displays
		WebElement dateTimeFrame = driver.findElement(By.xpath(DATE_TIME_FRAME));
		wait.until(ExpectedConditions.visibilityOf(dateTimeFrame));
		Assert.assertTrue(dateTimeFrame.isDisplayed());

		// Step 03 :
		WebElement dateBeforeSelect = driver.findElement(By.xpath(DATE_SELECTED_TEXT));
		Assert.assertEquals(dateBeforeSelect.getText(), "No Selected Dates to display.");

		// Step 04 : select 09/2017 and wait Loader is invisible
		clickByJS(MONTH_YEAR_BUTTON);
		click(SEP_BUTTON);
		click(YEAR_2017);
		click(OK_BUTTON);

		// Step 05 : wait Loader ajax invisible
			
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADER_JVAX)));
		

		// Step 06 : wait date 23 displays
		click(DATE_23);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".raDiv"))));
		WebElement dateAfterSelect = driver.findElement(By.xpath(DATE_SELECTED_TEXT));
		Assert.assertTrue(dateAfterSelect.isDisplayed());

		Thread.sleep(5000);

		// Step 07 : verify text after select date
		Assert.assertEquals(driver.findElement(By.xpath(DATE_SELECTED_TEXT)).getText(), "Saturday, September 23, 2017");
		System.out.println(driver.findElement(By.xpath(DATE_SELECTED_TEXT)).getText());

		driver.quit();
	}

	@Test
	public void testScript_03_FluentWait() {
		driver.get(urlTestScript03);
		waitUntilElementExistsAndGetsValue(15, 01, COUNTDOWN_TIME, valueTIMEEX);
		driver.quit();
	}
	
	@Test
	public void testScript_04_FluentWait2() {
		
		driver.get(urlTestScript04);
		
		// MOve to element
		moveToElementByJS(JAVASCRIPT_PLACE);
		
		//Wait fluent 2
		waitUntilElementExistsAndGetsValue(45, 10, BUZZBUZZ, valueBUZZ);
		
		new FluentWait<WebDriver>(driver).withTimeout(45, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
		.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wd) {
				WebElement timeChange = wd.findElement(By.xpath(CHANGE_COLOUR));
				System.out.println(timeChange.getAttribute("style"));
				return timeChange.getAttribute("style").contains("red");
			}
		});
	}
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String checkOS() {
		return System.getProperty("os.name").toLowerCase();

	}

	public void startChromeDriver() {
		if (checkOS().contains("mac")) {
			System.out.println("Open Chrome on MAC");
			System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver");
			driver = new ChromeDriver();
		} else if (checkOS().contains("win")) {
			System.out.println("Open Chrome on Win");
			System.setProperty("webdriver.chrome.driver", "//driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("System not found");
		}
	}

	public void openBrowser(String browser, String url) {
		if (browser.toLowerCase().contains("chrome")) {
			startChromeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else if (browser.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
			driver.get(url);
			System.out.println(checkOS());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else {
			System.out.println(browser + " is not found");
		}
	}

	public void click(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void selectDay(String day) {

	}

	public void clickByJS(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void checkLoader() {
		WebElement element = driver.findElement(By.xpath(LOADER_JVAX));
		if (element.isDisplayed()) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADER_JVAX)));
		} else {
			System.out.println("No loader");
		}
	}

	public void waitUntilElementExistsAndGetsValue(int timeOut, int defaultSleep,final String xpath, final String value) {
		new FluentWait<WebDriver>(driver).withTimeout(timeOut, TimeUnit.SECONDS).pollingEvery(defaultSleep, TimeUnit.SECONDS)
				.until((new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver wd) {
						WebElement element = wd.findElement(By.xpath(xpath));
						System.out.println(element.getText());
						return element.getText().equals(value);
					}}));
	}
	public void moveToElementByJS(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public Boolean apply2( String xpath, String value) {
		WebElement element = driver.findElement(By.xpath(xpath));
		System.out.println(element.getText());
		return element.getText().equals(value);
	}
	
	public Boolean apply1( String xpath,String atribute, String value) {
		WebElement element = driver.findElement(By.xpath(xpath));
		System.out.println(element.getAttribute(atribute));
		return element.getAttribute(atribute).contains(value);
	}
	
	String urlTestScript01 = "http://the-internet.herokuapp.com/dynamic_loading/2";
	String urlTestScript02 = "http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx";
	String urlTestScript03 = "https://stuntcoders.com/snippets/javascript-countdown/";
	String urlTestScript04 = "http://toolsqa.wpengine.com/automation-practice-switch-windows/";
	
	String START_BUTTON = "//div[@id='start']/button[contains(text(),'Start')]";
	String HELLO_WORD_TEXT = ".//div[@id='finish']/h4[contains(text(),'Hello World!')]";

	String DATE_TIME_FRAME = "//div[@class='RadCalendar RadCalendar_Silk']";
	String DATE_SELECTED_TEXT = "//span[@class='label']";

	String DAY_FRAME = "//tr[@class='rcRow']//parent::tbody";
	String DATE_23 = "//a[text()='23']";
	String DATE_23_AFTER_SELECT = "//*[contains(@class,'rcSelected')]//a[text()='23']";

	String MONTH_YEAR_BUTTON = "//span[@class='rcTitle']";
	String SEP_BUTTON = "//td[@id='rcMView_Sep']";
	String YEAR_2017 = ".//td[@id='rcMView_2017']";
	String OK_BUTTON = ".//a[@id='rcMView_OK']";
	String LOADER_JVAX = "//div[@class='raDiv']";
	
	String COUNTDOWN_TIME = "//div[@id='javascript_countdown_time']";
	String valueTIMEEX = "01:01:00";
	
	String BUZZBUZZ = "//span[@id='clock']";
	String valueBUZZ = "Buzz Buzz";
	String CHANGE_COLOUR = "//button[@id='colorVar']";
	String colourTextRed = "color: red;";
	String JAVASCRIPT_PLACE = "//h2[contains(.,'2) Java Script Alert')]";
}
