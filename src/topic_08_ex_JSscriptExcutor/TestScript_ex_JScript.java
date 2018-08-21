package topic_08_ex_JSscriptExcutor;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


public class TestScript_ex_JScript {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		 driver = new FirefoxDriver(); 

//		driver = new SafariDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testScript_01() throws InterruptedException {
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Step 02 : Get domain by JS
		Assert.assertEquals(getDomainByJS(), "live.guru99.com");

		// Get title by JS
		Assert.assertEquals(getTitlePageByJS(), "Home page");

		// Step 03 : Get Url by JS
		Assert.assertEquals(getUrlByJs(), "http://live.guru99.com/");

		// Step 04 : open Mobile by JS
		clickByJScriptEx(MOBILE_BUTTON);

		// Step 05 : Add Samsung Galaxy to cart
		clickByJScriptEx(ADDCART_SAMSUNG_GALA_BUTTON);

		// Step 06 : Verify message is displayed
		Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));
		System.out.println("Samsung Galaxy is added");

		// Step 07 : Open Policy by JS
		clickByJScriptEx(POLICY_BUTTON);

		// Verify title of Policy page
		Assert.assertEquals(getTitlePageByJS(), "Privacy Policy");

		// Step 08 : scroll to end Page
		scrollToBottomPage();

		// Step 09 : verify element display
		Assert.assertTrue(driver.findElement(By.xpath(WISHLIST_BOTTOM)).isDisplayed());
		System.out.println(driver.findElement(By.xpath(WISHLIST_BOTTOM)).getText());

		// Step 10 : Navigate to domain
		JavascriptExecutor jsNavi = (JavascriptExecutor) driver;
		jsNavi.executeScript("window.location = 'http://demo.guru99.com/v4/'");

		// Verify domain of demo guru after navigate
		Assert.assertEquals(getDomainByJS(), "demo.guru99.com");

	}

	@Test
	public void testScript_02() {
		navigateByJS("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");

		// Step 01 : switch to iframe by element
		switchElement(IFRAME_LOGIN);

		// Step 02 : remove disable of last name
		removeDisableByJS(LASTNAME_FIELD);

		// Step 03 : send text to Last name
		sendKeys(LASTNAME_FIELD, "Automation testing");

		// Step 04 : click Subit button
		clickByJScriptEx(SUBMIT_BUTTON);

		// Step 05 : verify text input
		Assert.assertEquals(getText(TEXT_YOU_INPUT), "fname=&lname=Automation testing");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void clickByJScriptEx(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px groove green'", element);
		js.executeScript("arguments[0].click();", element);

	}

	public String getTitlePageByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		System.out.println("Title of Page is : " + title);
		return title;
	}

	public String getUrlByJs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String urlPage = js.executeScript("return document.URL;").toString();
		System.out.println("URL of Page is : " + urlPage);
		return urlPage;
	}

	public String getDomainByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String domain = js.executeScript("return document.domain").toString();
		System.out.println("Domain is : " + domain);
		return domain;
	}

	public String getInnerText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String innText = (String) js.executeScript("return document.documentElement.innerText;");
		return innText;
	}

	public Object scrollToBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public void removeDisableByJS(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled');", element);
	}

	public void navigateByJS(String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location = '" + url + "'");
	}

	public void switchElement(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public void sendKeys(String locator, String text) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px groove green'", element);
		element.sendKeys(text);

	}

	public String getText(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px groove green'", element);
		String text = element.getText().trim();
		System.out.println(text);
		return text;
	}

	String MOBILE_BUTTON = "//a[contains(text(),'Mobile')]";
	String ADDCART_SAMSUNG_GALA_BUTTON = "//button[contains(@onclick,'product/3/')]";
	String POLICY_BUTTON = "//a[contains(text(),'Privacy Policy')]";
	String WISHLIST_BOTTOM = "//th[contains(.,'WISHLIST_CNT')]";

	String IFRAME_LOGIN = "//iframe[@id='iframeResult']";
	String LASTNAME_FIELD = "//input[@name='lname']";
	String TEXT_YOU_INPUT = "//div[@class='w3-container w3-large w3-border']";
	String SUBMIT_BUTTON = "//input[@type='submit']";
}