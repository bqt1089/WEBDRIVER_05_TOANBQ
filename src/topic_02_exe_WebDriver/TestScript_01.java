package topic_02_exe_WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScript_01 {
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.get("http://live.guru99.com/");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	  }
	
	@Test
	public void exercise01() {
	  //Step 02 : Verify title is Home Page
	  String homePageTitle = driver.getTitle();
	  System.out.println("Check Home Page title");
	  Assert.assertEquals(homePageTitle, "Home page");
	
	  
	  //Step 03 : Click on My Account
	  String MYACCOUNT_BUTTON = "//div[@class='footer']//a[contains(.,\"My Account\")]";
	  driver.findElement(By.xpath(MYACCOUNT_BUTTON)).click();
	 
	  //Step 04 : Click on Create Account
	  String CREATE_ACCOUNT = "//a[@title='Create an Account']";
	  driver.findElement(By.xpath(CREATE_ACCOUNT)).click();
	  
	  //Step 05 : Back to Login Page
	  driver.navigate().back();
	  
	  //Step 06 : Verify url of Login page
	  String loginPage = driver.getCurrentUrl();
	  System.out.println("Check Url of Login Page ");
	  Assert.assertEquals(loginPage, "http://live.guru99.com/index.php/customer/account/login/");
	  
	  //Step 07 : Forward to Create Account
	  driver.navigate().forward();
	  
	  //Step 08 : Verify url of Create Account
	  String createPage = driver.getCurrentUrl();
	  System.out.println("Check url of Create Account page ");
	  Assert.assertEquals(createPage, "http://live.guru99.com/index.php/customer/account/create/");
	  }
  
	@AfterClass
  public void afterClass() {
	  driver.quit();
  }
}
