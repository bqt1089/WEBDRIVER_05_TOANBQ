package topic_11_TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Loop{
	WebDriver driver;
	WebDriverWait waitExplicit;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browser) {
		if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equals("chrome_headless")) {
			System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("windown-size-1366-768");
			driver = new ChromeDriver(options);
		}

		waitExplicit = new WebDriverWait(driver, 10);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Parameters({ "user", "pass" })
	@Test (invocationCount = 2)
	public void runMultiBrowser(String user, String pass) {
		driver.get("http://live.guru99.com/");
		
		// Step 01 : click on My Account button with xpath
		// (//div[@class='footer-container']//a[@title='My Account'])
		driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();

		// Step 02 : input ID with xpath (//input[@id='email'])
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);

		// Step 03 : input Pass with xpath (//input[@id='pass'])
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);

		// Step 04 : click Login button with xpath (//button[@id='send2'])
		driver.findElement(By.xpath("//button[@id='send2']")).click();

		// Step 05 : verify Image Magento appears with xpath
		// (//a[@class='logo']/img[@class='large'])
		WebElement myDashBoard = driver.findElement(By.xpath("//div[@class='col-main']"));
		waitExplicit.until(ExpectedConditions.visibilityOf(myDashBoard));
		AssertJUnit.assertTrue(myDashBoard.isDisplayed());

		// Step 06 : click on Account button with xpath
		// (//div[@class='account-cart-wrapper']//span[contains(.,'Account')])
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[contains(.,'Account')]")).click();

		// Step 07 : click Log out button with xpath (//a[@title='Log Out'])
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
