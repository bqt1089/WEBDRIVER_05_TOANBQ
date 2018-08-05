package topic_04_ex_textbox_dropdown;

import java.util.Random;
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

public class Testscript_03_Topic_04 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void f() {
		Random number = new Random();
		int num = number.nextInt(999999);
		String numb = String.valueOf(num);

		// Step 02 : Login with Email & Password
		sendText(LOGIN_EMAIL_TEXTBOX, emailID);
		sendText(LOGIN_PASS_TEXTBOX, passWord);
		click(LOGIN_BUTTON);

		// Step 03 : click New Customer
		click(CUSTOMER_BUTTON);

		// Stp 04 : Input customer name
		sendText(CUSTOMER_NAME_TEXTBOX, "Bui Quang Toan");

		// Input Date of Birth et
		sendText(DATE_OF_BIRTH_TEXTBOX, "2018-01-01");
		// Input Address
		sendText(ADDRESS_TEXTAREA, "K132 nui thanh");

		// Input City
		sendText(CITY_TEXTBOX, "Da Nang");
		// Input State
		sendText(STATE_TEXTBOX, "Hai Chau");
		// Input Pin
		sendText(PIN_TEXTBOX, numb);
		// Input phone Number
		sendText(MOBILE_TEXTBOX, "9381" + num);
		// Input Email
		sendText(EMAIL_TEXTBOX, "bqt" + num + "@gmail.com");
		// Input password
		sendText(PASS_TEXTBOX, "12345678");

		click(SUBMIT_BUTTON);

		// Step 05 : Get Custemer ID
		String customerID = driver.findElement(By.xpath(CUSTOMER_ID_NUMBER)).getText();
		System.out.println("In ra customer ID " + customerID);

		// Step 06 : Click Edit customer to Edit profile
		click(EDIT_CUSTOM_BUTTON);

		// Step 07 : Verify Customer name and Address
		// Fill cusomer ID
		sendText(EDIT_CUSTOMER_ID_TEXTBOX, customerID);
		click(EDIT_SUBMIT_BUTTON);

		// Verify Customer and Address
		String customerName = driver.findElement(By.xpath(CUSTOMER_NAME_TEXTBOX)).getAttribute("value");
		System.out.println(customerName);
		Assert.assertEquals(customerName, "Bui Quang Toan");

		String addRess = driver.findElement(By.xpath(ADDRESS_TEXTAREA)).getText();
		System.out.println(addRess);
		Assert.assertEquals(addRess, "K132 nui thanh");

		//// Input new name and address
		sendTextInDisableBox(CITY_TEXTBOX, "Quang Nam");
		sendTextInDisableBox(ADDRESS_TEXTAREA, "K321 Da Nang");
		
		//Click Submit
		click(SUBMIT_BUTTON);
		
		
		verifyByText(ADDRESS_TABLE, "K321 Da Nang");
		verifyByText(CITY_TABLE, "Quang Nam");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sendText(String xpath, String value) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.isDisplayed();
		element.sendKeys(value);
	}

	public void click(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.isDisplayed();
		element.click();
	}

	public void verifyByGetAttribute(String xpath, String attribute, String value) {
		String element = driver.findElement(By.xpath(xpath)).getAttribute(attribute);
		System.out.println("Attribute = : "+element);
		Assert.assertEquals(element, value);
	}

	public void verifyByText(String xpath, String value) {
		String element = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(element);
		Assert.assertEquals(element, value);
	}

	public void sendTextInDisableBox(String xpath, String value) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled')", element);
		element.clear();
		element.sendKeys(value);
	}

	String LOGIN_EMAIL_TEXTBOX = "//input[@name='uid']";
	String LOGIN_PASS_TEXTBOX = "//input[@name='password']";
	String emailID = "mngr144991";
	String passWord = "upyhatE";
	String LOGIN_BUTTON = "//input[@name='btnLogin']";
	String CUSTOMER_BUTTON = "//a[contains(.,'New Customer')]";
	String EDIT_CUSTOM_BUTTON = "//a[contains(.,'Edit Customer')]";
	String CUSTOMER_NAME_TEXTBOX = "//input[@name='name']";
	String DATE_OF_BIRTH_TEXTBOX = "//input[@id='dob']";
	String ADDRESS_TEXTAREA = "//textarea[@name='addr']";
	String CITY_TEXTBOX = "//input[@name='city']";
	String STATE_TEXTBOX = "//input[@name='state']";
	String PIN_TEXTBOX = "//input[@name='pinno']";
	String MOBILE_TEXTBOX = "//input[@name='telephoneno']";
	String EMAIL_TEXTBOX = "//input[@name='emailid']";
	String PASS_TEXTBOX = "//input[@name='password']";
	String SUBMIT_BUTTON = "//input[@value='Submit']";

	String CUSTOMER_ID_NUMBER = "//td[text()='Customer ID']//following-sibling::td";
	String CUSTOMER_TABLE = "//td[text()='Customer Name']//following-sibling::td";
	String ADDRESS_TABLE = "//td[text()='Address']//following-sibling::td"; 
	String CITY_TABLE = "//td[text()='City']//following-sibling::td";
	
	String EDIT_CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	String EDIT_SUBMIT_BUTTON = "//input[@name='AccSubmit']";

}
