package topic_09_ex_UploadFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScript_01_SendKey {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		openBrowser("Chrome", "http://blueimp.github.io/jQuery-File-Upload/");
		
		driver.manage().window().maximize();
	}

	@Test
	public void testScript_01_SendKey() throws InterruptedException {
		// upload image on Chrome
		WebElement addFile = driver.findElement(By.xpath(ADDFILE_BUTTON));
		addFile.sendKeys(IMAGE_FILE_PATH);
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.xpath(UPLOADED_AREA)).isDisplayed());
		System.out.println(driver.findElement(By.xpath(UPLOADED_AREA)).getText());
		
		driver.close();
		
		//Upload image on Firefox
		openBrowser("Firefox", "http://blueimp.github.io/jQuery-File-Upload/");
		upLoadBySendKey(ADDFILE_BUTTON, IMAGE_FILE_PATH);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(UPLOADED_AREA)).isDisplayed());
		System.out.println(driver.findElement(By.xpath(UPLOADED_AREA)).getText());
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void openBrowser(String browser, String url) {
		if (browser.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
		} else if (browser.toLowerCase().contains("firefox")){
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
		} else if (browser.toLowerCase().contains("safari")) {
			System.setProperty("webdriver.safari.driver", safariDriver);
			driver = new SafariDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
		}
	}

	public void upLoadBySendKey(String locator, String file) {
			WebElement element = driver.findElement(By.xpath(locator));
			element.sendKeys(file);
			
	}
	
	
	
	String ADDFILE_BUTTON = "//input[@type='file']";
	
	String IMAGE_NAME = "//image/Upload1.png";
	
	String workingDirectory = System.getProperty("user.dir");
	String IMAGE_FILE_PATH = workingDirectory + "//image/Upload1.png";
	String UPLOADED_AREA = "//p[@class='name']";
	
	String safariDriver = workingDirectory + "//driver/SafariDriver.safariextz";

	
}
