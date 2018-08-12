package topic_07_ex_iframe_frame_window;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testscript_01_ex_frame {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void testSript_01_Topic07() {
			List<WebElement> iframe4 = driver.findElements(By.xpath(IFRAME_4)); 
			
			//Step 02 : If iframe appears, click to close
			if(iframe4.size()>0) {
				driver.switchTo().frame(iframe4.get(0));
				click(CLOSE_IFRAME4);	
			}
			
			//Step 03  : Switch to iframe that include Looking for Element
			switchIframe(IFRAME_2_LOOK);
			
			// Verify Looking for element
			WebElement areYouLook = driver.findElement(By.xpath(AREYOULOOKING));
			Assert.assertTrue(areYouLook.isDisplayed());
			System.out.println(areYouLook.getText());
			
			//switch back to TOP windown
			driver.switchTo().defaultContent();
			
			//Step 04 : switch to Iframe that have banner
			switchIframe(IFRAME_3_BANNER);
			
			//Veirify 6 banners
			List<WebElement> banners = driver.findElements(By.xpath(BANNER_IMG_LIST));
			Assert.assertEquals(banners.size(), 6);
			System.out.println("Total banners : "+ banners.size());
			
			driver.switchTo().defaultContent();
			List<WebElement> flipIcon = driver.findElements(By.xpath(FLIPICON_LIST));
			Assert.assertEquals(flipIcon.size(), 8);
			System.out.println("Total Flip icon banners : "+flipIcon.size());
			
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void switchIframe(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}
	public void click (String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	
	
	String IFRAME_4 = "//iframe[@id='vizury-notification-template']";
	String CLOSE_IFRAME4 = "//div[@id='div-close']";
	
	String IFRAME_2_LOOK = "//div[@class='flipBannerWrap']//iframe[contains(@id,'viz_iframe')]";
	String AREYOULOOKING = "//span[@id='messageText']";
	
	String IFRAME_3_BANNER = "//div[@class='slidingbanners']//iframe";
	String BANNER_IMG_LIST = "//div[@id='productcontainer']//img";
	
	String FLIPICON_LIST = "//div[@class='flipBanner']//div[contains(@class,'product')]";
	
}
