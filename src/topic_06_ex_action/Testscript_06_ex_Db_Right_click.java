package topic_06_ex_action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testscript_06_ex_Db_Right_click {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);
		
		
		driver.manage().window().maximize();
		
	}

	@Test
	public void testScript_03_DoubleCLick() {
		driver.get("http://www.seleniumlearn.com/double-click");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Double click to element
		WebElement doubleMe = driver.findElement(By.xpath(DOUBLE_CLICK_ME));
		Actions actionDouble = new Actions(driver);
		actionDouble.doubleClick(doubleMe).perform();
		
		//Verify text on Alert 
		Alert alert = driver.switchTo().alert();
		String textOnAlert = alert.getText();
		System.out.println("Text is : "+ textOnAlert);
		Assert.assertEquals(textOnAlert, "The Button was double-clicked.");
		alert.accept();
		
	}
	@Test
	public void testScript_04_RightClick() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Right click on element
		WebElement righClick = driver.findElement(By.xpath(RIGHT_CLICK));
		Actions actionRighClick = new Actions(driver);
		actionRighClick.contextClick(righClick).perform();
		
		//Hover to Quit item
		WebElement quitItem = driver.findElement(By.xpath(QUIT_ITEM));
		Actions actionsMove = new Actions(driver);
		actionsMove.moveToElement(quitItem).perform();
		
		//verify Quit item is display
		verifyDisplay(QUIT_ITEM_VISIBLE);
		
		//Click on Quit item
		WebElement quitVisible = driver.findElement(By.xpath(QUIT_ITEM_VISIBLE));
		quitVisible.click();
		
		//Accept Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void verifyDisplay(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertTrue(element.isDisplayed());
	}
	
	String DOUBLE_CLICK_ME = "//button[contains(.,'Double-Click Me!')]";
	String RIGHT_CLICK = "//span[contains(.,'right click me')]";
	String QUIT_ITEM = "//li[contains(@class,'menu-icon-quit')]";
	String QUIT_ITEM_VISIBLE = "//li[contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]";
	
}
