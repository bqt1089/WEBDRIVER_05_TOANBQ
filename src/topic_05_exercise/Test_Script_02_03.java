package topic_05_exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Test_Script_02_03 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TC02_CheckBox() throws InterruptedException {
		openUrl("http://demos.telerik.com/kendo-ui/styling/checkboxes");
		click(DUAL_ZONE_CHECKBOX);
		verifySelected(DUAL_ZONE_CUBE_CHECKBOX, "Check box");
	}

	@Test
	public void TC03_RadioButton() {
		openUrl("http://demos.telerik.com/kendo-ui/styling/radios");
		click(PETRO_20_RADIO_BUTTON);
		verifySelected(PETRO_20_CUBE_RADIO, "Radio button");
	}

	@Test
	public void TC04_JS_Alert() {
		openUrl("http://daominhdam.890m.com/#");
		click(JS_FOR_ALEART);
		alertJS("I am a JS Alert");
		verifyTextAlert(RESULT_TEXT_AFTER_ALERT, "You clicked an alert successfully");
	
	}

	@Test
	public void TC05_JS_Confirm() {
		openUrl("http://daominhdam.890m.com/#");
		click(JS_ALERT_CONFIRM);
		disMissAlertJSConfirm("I am a JS Confirm");
		verifyTextAlert(RESULT_TEXT_AFTER_ALERT, "You clicked: Cancel");
	
	}

	@Test
	public void TC05_JS_Promt() {
		openUrl("http://daominhdam.890m.com/#");
		click(JS_ALERT_PROMT);
		acceptAlertPromt("I am a JS prompt", "buiquangtoan");
		verifyTextAlert(RESULT_TEXT_AFTER_ALERT, "You entered: buiquangtoan");
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

	public void openUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void verifySelected(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		Assert.assertTrue(element.isSelected());
		System.out.println( value +" is selected ");
	}
	public void verifyTextAlert (String locator, String value) {
		WebElement element =driver.findElement(By.xpath(locator));
		String actual = element.getText();
		Assert.assertEquals(actual, value);
		System.out.println(actual);
	}
	public void alertJS (String expected) {
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		Assert.assertEquals(actual, expected);
		alert.accept();
	}
	public void disMissAlertJSConfirm(String expected) {
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		Assert.assertEquals(actual, expected);
		alert.dismiss();
	}
	public void acceptAlertPromt(String expected, String value) {
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		Assert.assertEquals(actual, expected);
		alert.sendKeys(value);
		alert.accept();
	}
	
	

	String DUAL_ZONE_CHECKBOX = "//label[contains(.,'Dual-zone air conditioning')]";
	String DUAL_ZONE_CUBE_CHECKBOX = "//label[contains(.,'Dual-zone air conditioning')]//../input";

	String PETRO_20_RADIO_BUTTON = "//ul[@class='fieldlist']//label[contains(.,'2.0 Petrol, 147kW')]";
	String PETRO_20_CUBE_RADIO = "//ul[@class='fieldlist']//label[contains(.,'2.0 Petrol, 147kW')]//../input";
	
	String JS_FOR_ALEART = "//button[contains(text(),'Click for JS Alert')]";
	String JS_ALERT_CONFIRM = "//button[contains(text(),'Click for JS Confirm')]";
	String JS_ALERT_PROMT = "//button[contains(text(),'Click for JS Prompt')]";
	
	String RESULT_TEXT_AFTER_ALERT = "//p[@id='result']";
}
