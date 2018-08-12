package topic_06_ex_action;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testscrtipt_06_MoveMouse_hover {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);

		driver.manage().window().maximize();
	}

	@Test
	public void testScrip01() throws InterruptedException {
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Scroll and moves to Hover Over Me Tolltip
		moveMouse(HOLDOVERME);
		Thread.sleep(3000);

		// Verify tool tip display and text is correct
		verifyDisplay(TOOLTIP_TEXT, "Hooray!");
	}

	@Test
	public void testScript02Case01() {
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Move and hover mouse to Menu
		moveMouse(ACCOUNT_MENU);

		// Click on Login button
		click(LOGIN_BUTTON);

		// Verify Login page displays
		verifyDisplay(LOGIN_TO_MYNTRA, "Login to Myntra");

	}

	@Test
	public void testSript02Case02() {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// click and move from 1 to 4
		clickAndHoldByIndex(NUMBER, number);
		verifyClickAndHold(NUMBER_SELECTED, 4);
		
	}

	@Test
	public void testScript04() {
		driver.get("http://www.seleniumlearn.com/double-click")
		;
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void moveMouse(String loacator) {
		WebElement element = driver.findElement(By.xpath(loacator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void verifyDisplay(String locator, String textelement) {
		WebElement element = driver.findElement(By.xpath(locator));
		wait.until(ExpectedConditions.visibilityOf(element));
		AssertJUnit.assertTrue(element.isDisplayed());
		System.out.println("Text : " + element.getText() + " is displayed ");
		AssertJUnit.assertEquals(element.getText(), textelement);
	}

	public void click(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickAndHoldByIndex(String locator, int[] array) {
		List<WebElement> element = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		for (int i=0; i<array.length; i++) {
			element.get(i).click();
		}
		action.keyUp(Keys.CONTROL).build().perform();
	}
	public void verifyClickAndHold (String locator, int expected) {
		List<WebElement> element = driver.findElements(By.xpath(locator));
		Assert.assertEquals(element.size(), expected);
		System.out.println("Size number is selected : " + element.size());
	}
	
	

	String HOLDOVERME = "//a[@data-toggle='tooltip']";
	String TOOLTIP_TEXT = "//div[@class='tooltip-inner']";

	String ACCOUNT_MENU = "//span[@class='myntraweb-sprite desktop-iconUser sprites-user']";
	String LOGIN_BUTTON = "//a[@data-track='login']";
	String LOGIN_TO_MYNTRA = "//p[@class='login-title']";

	int[] number = { 0, 1, 2, 3 };
	String NUMBER = ".//ol[@id='selectable']/li";
	String NUMBER_SELECTED = "//li[@class='ui-state-default ui-selectee ui-selected']";
}
