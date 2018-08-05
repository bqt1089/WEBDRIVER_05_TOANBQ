package topic_05_ex_radio_checkbox;

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

public class Test_Script_01 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC001_ClickByTwoWays() {
		// Step 02 : Click to My Account
		click(MYACCOUNT_BUTTON);
		// Step 03 : Verify current URL
		verifyUrl(myAccountUrl);
		// Step 04 : Click to Create An Account
		clickElementByJavascript(CREATE_ACCOUNT_BUTTON);
		// Step 05 : Verify current URL
		verifyUrl(createAccountUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sendKeys(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void click(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void verifyUrl(String expected) {
		String actual = driver.getCurrentUrl();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}

	public void clickElementByJavascript(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

	String MYACCOUNT_BUTTON = "//div[@class='footer']//a[contains(.,'My Account')]";
	String CREATE_ACCOUNT_BUTTON = "//div[@class='buttons-set']//a[contains(.,'Create an Account')]";
	String myAccountUrl = "http://live.guru99.com/index.php/customer/account/login/";
	String createAccountUrl = "http://live.guru99.com/index.php/customer/account/create/";

}
