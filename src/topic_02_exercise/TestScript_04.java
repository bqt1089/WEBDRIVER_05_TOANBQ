package topic_02_exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;

public class TestScript_04 {
	WebDriver driver;
	
  @BeforeClass
	  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("http://live.guru99.com/");
	  driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  }	
  @Test
  public void f() {
	  //Step 02 : click to My Account
	   String MYACCOUNT_BUTTON = "//div[@class='footer']//a[contains(.,\"My Account\")]";
	   driver.findElement(By.xpath(MYACCOUNT_BUTTON)).click();
	   
	   //Step 03 : Input correct email and incorrect password
	   String emailText = "automation@gmail.com";
	   String EMAIL_TEXTFIELD = "//input[@id='email']";
	   driver.findElement(By.xpath(EMAIL_TEXTFIELD)).sendKeys(emailText);
	   
	   String passText = "123";
	   String PASS_TEXTFIELD = "//input[@id='pass']";
	   driver.findElement(By.xpath(PASS_TEXTFIELD)).sendKeys(passText);
	   
	   
	  //Step 04 : Tap on Login button
	   String LOGIN_BUTTON = "//*[@id='send2']";
	   driver.findElement(By.xpath(LOGIN_BUTTON)).click();
	   
	   //Step 05 : Verify error message password error
	   System.out.println("Verify error message when password is incorrect");
	   String passError = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
	   Assert.assertEquals(passError, "Please enter 6 or more characters without leading or trailing spaces.");
	   
  } 

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
