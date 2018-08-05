package topic_02_exe_WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScript_03 {
	WebDriver driver;
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	  }
	
	@Test
  public void f() {
		//Step 02 : Click to My account
		 String MYACCOUNT_BUTTON = "//div[@class='footer']//a[contains(.,\"My Account\")]";
		 driver.findElement(By.xpath(MYACCOUNT_BUTTON)).click();
		
		 //Step 03 : Send text to email
		 String emailText = "123434234@12312.123123";
		 String EMAIL_TEXTFIELD = "//input[@id='email']";
		 driver.findElement(By.xpath(EMAIL_TEXTFIELD)).sendKeys(emailText);
		 
		//Step 04 : Click on LOGIN BUTTON
		  String LOGIN_BUTTON = "//*[@id='send2']";
		  driver.findElement(By.xpath(LOGIN_BUTTON)).click();
		  
		//Step 05 : Verify error message appear
		  System.out.println("Verify error message : Please enter a valid address");
		  String mailError = driver.findElement(By.xpath(".//*[@id='advice-validate-email-email']")).getText();
		  Assert.assertEquals(mailError, "Please enter a valid email address. For example johndoe@domain.com.");
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
