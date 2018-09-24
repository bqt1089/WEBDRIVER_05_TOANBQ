package topic_06_ex_action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testscript_06_ex_DragDrop {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testScript_04_DragDrop() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Verify before drag and drop
		verifyText(DROP_PLACE, "Drag the small circle here.");

		// Drag and Drop item
		WebElement sourceTarget = driver.findElement(By.xpath(SOURCE_ITEM));
		WebElement dropPlace = driver.findElement(By.xpath(DROP_PLACE));

		Actions dragDrop = new Actions(driver);
		dragDrop.dragAndDrop(sourceTarget, dropPlace).perform();


		// Verify before drag and drop
		verifyText(DROP_PLACE, "You did great!");

	}

	@Test
	public void testScript_05_DragDrop() {
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Verify before drag and drop
		verifyText(DROP_HERE, "Drop here");

		// Drag and Drop item
		WebElement sourceTarget = driver.findElement(By.xpath(SOURCE_ITEM));
		WebElement dropPlace = driver.findElement(By.xpath(DROP_HERE));

		Actions dragDrop = new Actions(driver);
		dragDrop.dragAndDrop(sourceTarget, dropPlace).perform();
		;

		// Verify before drag and drop
		verifyText(DROP_HERE, "Dropped!");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void verifyText(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		Assert.assertEquals(element.getText(), value);
		System.out.println(element.getText());
	}

	String SOURCE_ITEM = "//div[@id='draggable']";
	String DROP_PLACE = "//div[@id='droptarget']";

	String DROP_HERE = "//div[@id='droppable']";
}
