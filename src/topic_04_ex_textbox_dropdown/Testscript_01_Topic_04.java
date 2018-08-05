package topic_04_ex_textbox_dropdown;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testscript_01_Topic_04   {
	WebDriver driver;
	String JOBROLE01_DROPDOWN = "//select[@id='job1']";
	
	
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	  }

  @Test
  public void f() {
	  checkMultiSelect(JOBROLE01_DROPDOWN);
	  selectByVisble(JOBROLE01_DROPDOWN, "Automation Tester", "Automation Tester");
	  selectByValue(JOBROLE01_DROPDOWN, "manual", "Manual Tester");
	  selectByIndex(JOBROLE01_DROPDOWN, 3, "Mobile Tester");
	  
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  	public void checkMultiSelect(String xpath) {
  		Select dropDown = new Select(driver.findElement(By.xpath(xpath)));
  		Assert.assertFalse(dropDown.isMultiple());
  		System.out.println("Dropdown is not Multiple Select");
  	}
  	public void selectByVisble(String xpath, String value, String expected) {
  		Select dropDown = new Select(driver.findElement(By.xpath(xpath)));
  		dropDown.selectByVisibleText(value);
  		String actual = dropDown.getFirstSelectedOption().getText();
  		Assert.assertEquals(actual, expected);
  		System.out.println(actual + " is selected");
  	}
  	public void selectByValue(String xpath, String value, String expected) {
  		Select dropDown = new Select(driver.findElement(By.xpath(xpath)));
  		dropDown.selectByValue(value);
  		String actual = dropDown.getFirstSelectedOption().getText();
  		Assert.assertEquals(actual, expected);
  		System.out.println(actual + " is selected");
  	}
  	public void selectByIndex(String xpath, int index, String expected) {
  		Select dropDown = new Select(driver.findElement(By.xpath(xpath)));
  		dropDown.selectByIndex(index);
  		String actual = dropDown.getFirstSelectedOption().getText();
  		Assert.assertEquals(actual, expected);
  		System.out.println(actual + " is selected");
  	}
  	
  	
  	
}
