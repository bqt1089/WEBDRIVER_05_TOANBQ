package topic_04_ex_textbox_dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Testscript_02_Topic04 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		
		driver.manage().window().maximize();
	}

	@Test
	public void TC002_Click_Item19() throws InterruptedException {
		// Jquery
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[@id='speed-button']")).click();
		
		customDropdownList(DROPDOWN_NUMBER, DROPDOWN_LIST_NUMBER, itemExpected);
		verifyFirstOption(FIRSTOPTION_NUMBER, itemExpected);
		
		//Angular
		driver.get("https://material.angular.io/components/select/examples");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		customDropdownList(FAVOURITE_FOOD_DROPDOWN, FAVOURITE_FOOD_DROPLIST, "Pizza");
		Thread.sleep(3000);
		verifyFirstOption(FIRSTOPTION_FOOD, "Pizza");
		
		//Kendo
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		customDropdownList(CAP_COLOUR_DROPDOWN, CAP_COLUR_DROPLIST, "Grey");
		Thread.sleep(3000);
		verifyFirstOption(FIRST_OPTIONS_CAP, "Grey");
		
		//VuJS
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		customDropdownList(VUJS_DROPDOWN, VUJS_DROPLIST, "Third Option");
		Thread.sleep(3000);
		verifyFirstOption(VUJS_DROPDOWN, "Third Option");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void click(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void customDropdownList(String locator, String itemsList, String itemvalue) {
		// click dropdown
		click(locator);
		// Tao list
		List<WebElement> allItems = driver.findElements(By.xpath(itemsList));
		// wait tat ca hien thi
		wait.until(ExpectedConditions.visibilityOfAllElements(allItems));

		for (WebElement items : allItems) {
			System.out.println("List items : "+ items.getText());
			if (items.getText().trim().equals(itemvalue)) {
				//Scroll to item
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", items);
				items.click();
				break;
			}
		}
	}
	public void verifyFirstOption(String locator, String value) {
		String element = driver.findElement(By.xpath(locator)).getText();
		Assert.assertEquals(element, value);
		System.out.println("First option is : "+element);
	}
	
	//Jquery
	String itemExpected = "19";
	String DROPDOWN_LIST_NUMBER = "//ul[@id='number-menu']//li[@class='ui-menu-item']/div";
	String DROPDOWN_NUMBER = "//span[@id='number-button']";
	String FIRSTOPTION_NUMBER = ".//span[@id='number-button']/span[@class='ui-selectmenu-text']";
	
	//Angular
	String FAVOURITE_FOOD_DROPDOWN = "//select-overview-example[@class='ng-star-inserted']//div[@class='mat-form-field-flex']";
	String FAVOURITE_FOOD_DROPLIST = "//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']//span";
	String FIRSTOPTION_FOOD = "//span[@class='mat-select-value-text ng-tns-c21-4 ng-star-inserted']/span";
	
	//Kendo
	String CAP_COLOUR_DROPDOWN = "//span[@aria-owns='color_listbox']";
	String CAP_COLUR_DROPLIST = "//ul[@id='color_listbox']/li";
	String FIRST_OPTIONS_CAP = "//span[@aria-owns='color_listbox']";
	
	//VuJS
	String VUJS_DROPDOWN = "//li[@class='dropdown-toggle']";
	String VUJS_DROPLIST = "//ul[@class='dropdown-menu']/li";
	
}
