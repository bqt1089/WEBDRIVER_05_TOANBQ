package topic_02_exe_WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;

public class TestScript_02 {
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
		//Step 02 : Click on My Account
		  String MYACCOUNT_BUTTON = "//div[@class='footer']//a[contains(.,\"My Account\")]";
		  driver.findElement(By.xpath(MYACCOUNT_BUTTON)).click();
		  
		//Step 04 : Click on LOGIN BUTTON
		  String LOGIN_BUTTON = "//*[@id='send2']";
		  driver.findElement(By.xpath(LOGIN_BUTTON)).click();
		
		//Step 5 : Verify error message appear 
		  System.out.println("Verify error message at email");
		  String errorMessMail = driver.findElement(By.xpath("//*[@id='advice-required-entry-email']")).getText();
		  Assert.assertEquals(errorMessMail, "This is a required field.");
		  
		  System.out.println("Verify error message at password");
		  String errorMessPass = driver.findElement(By.xpath("//*[@id='advice-required-entry-pass']")).getText();
		  Assert.assertEquals(errorMessPass, "This is a required field.");
		  
  }
 

	@AfterClass
  public void afterClass() {
		driver.quit();
  }

}
