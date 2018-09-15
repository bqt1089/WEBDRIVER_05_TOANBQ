package topic_11_TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProviders {
	WebDriver driver;
	WebDriverWait waitExplicit;

	@Test(dataProvider = "UserAndPassword")
	public void loginWithMultiUsrAndPass(String user, String pass) {
		//Step 01 : click on My Account button with xpath (//div[@class='footer-container']//a[@title='My Account'])
		driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();;
		
		//Step 01 : input ID with xpath (//input[@id='email'])
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);
		
		//Step 02 : input Pass with xpath (//input[@id='pass'])
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
		
		//Step 03 : click Login button with xpath (//button[@id='send2'])
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		
		//Step 04 : verify Image Magento appears with xpath (//a[@class='logo']/img[@class='large'])
		WebElement myDashBoard = driver.findElement(By.xpath("//div[@class='col-main']"));
		waitExplicit.until(ExpectedConditions.visibilityOf(myDashBoard));
		Assert.assertTrue(myDashBoard.isDisplayed());
		
		//Step 05 : click on Account button with xpath (//div[@class='account-cart-wrapper']//span[contains(.,'Account')])
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[contains(.,'Account')]")).click();
		
		//Step 06 : click Log out button with xpath (//a[@title='Log Out'])
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();;
		
//		//Step 07 : verify Log out disappears with xpath (//*[contains(.,'You are now logged out')])	
//		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(.,'You are now logged out')]")));
//		
//		String titleHome = driver.getTitle();
//		Assert.assertEquals(titleHome, "Home page");
		
	}

	@DataProvider
	public Object[][] UserAndPassword() {
		return new Object[][] { 
				{ "automationvalid_01@gmail.com", "111111" },
				{ "automationvalid_02@gmail.com", "111111" }, 
				{ "automationvalid_03@gmail.com", "111111" } };
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		waitExplicit = new WebDriverWait(driver, 10);
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}