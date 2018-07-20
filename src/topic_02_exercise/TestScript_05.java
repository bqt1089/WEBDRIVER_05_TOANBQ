package topic_02_exercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScript_05 {
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
//		  System.setProperty("webdriver.chrome.driver", "//WEBDRIVER_05_TOANBQ/driver/chromedriver");
//		  driver = new ChromeDriver();
		  driver  = new FirefoxDriver();
		  driver.get("http://live.guru99.com/");
		  driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	  }
	
	@Test
  public void f() {
			
			//Step 02 : click to My Account
		   String MYACCOUNT_BUTTON = "//div[@class='footer']//a[contains(.,'My Account')]";
		   click(MYACCOUNT_BUTTON);
		   
		   //Step 03 : click to Create Account
		   String CREATE_ACCOUNT_BUTTON = "//div[@class='buttons-set']//a[contains(.,'Create an Account')]";
		   click(CREATE_ACCOUNT_BUTTON);
		   
		   //Random number
		   Random r = new Random();
		   int num = r.nextInt(99999);
		   System.out.println(num);
		   
		   //Step 04 : Input First Name
		   String FIRST_NAME = "//input[@id='firstname']";
		   sendText(FIRST_NAME, "Toan");
		   
		   //Step 04 : Input Last Name
		   String LAST_NAME = "//input[@id='lastname']";
		   sendText(LAST_NAME, "Bui");
		   
		   //Step 04 : Input Email
		   String EMAIL_ADD = "//input[@id='email_address']";
		   sendText(EMAIL_ADD, "Toan.bui"+num+"@gmail.com");
		   
		   String email = driver.findElement(By.xpath(EMAIL_ADD)).getText();
		   System.out.println(email);
		   
		   //Step 04 : Input Pass & confirm Pass
		   String PASSWORD = "//input[@id='password']";
		   sendText(PASSWORD, "12345678");
		   
		   String CONFIRM_PASS = "//input[@id='confirmation']";
		   sendText(CONFIRM_PASS, "12345678");
		   
		   //Step 05 : Click Register button
		   String REGISTER_BUTTON = "//div[@class='buttons-set']/button[@class='button']";
		   click(REGISTER_BUTTON);
		   
		   //Step 05 : Verify text success appear
		   String SUCESS_MESS = "//ul[@class='messages']//span[contains(.,'Thank ')]";
		   String sucessMEss = driver.findElement(By.xpath(SUCESS_MESS)).getText();
		   Assert.assertEquals(sucessMEss, "Thank you for registering with Main Website Store.");
		   
		   //Step 06 : Log out 
		   String LOGIN_BUTTON = "//div[@id='header-account']//a[contains(.,'Log Out')]";
		   String ACCOUNT_BUTTON = ".//*[@id='header']//span[contains(.,'Account')]";
		   click(ACCOUNT_BUTTON);
		   click(LOGIN_BUTTON);
		   
		    try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		   //Step 07 : Verify back to Home Page
		   String homePageTitle = "Home page";
		   String getHomePageTitle = driver.getTitle();
		   System.out.println(getHomePageTitle);
		   Assert.assertEquals(getHomePageTitle, homePageTitle);
		  
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  	public void click(String xpath) {
  		WebElement elemnent = driver.findElement(By.xpath(xpath));
  		elemnent.click();
  	}
  	public void sendText(String xpath, String value) {
  		WebElement element = driver.findElement(By.xpath(xpath));
  		element.sendKeys(value);
  	}

}
