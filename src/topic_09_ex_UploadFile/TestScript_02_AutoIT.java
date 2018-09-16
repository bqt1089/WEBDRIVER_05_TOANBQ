package topic_09_ex_UploadFile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScript_02_AutoIT {
    WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		openBrowser("firefox", "http://blueimp.github.com/jQuery-File-Upload/");
		//test
	}

	@Test
	public void f() throws IOException, InterruptedException {
		
		WebElement addFile = driver.findElement(By.cssSelector(ADDFILE_BY_CSS));
		addFile.click();
		
		
		Runtime.getRuntime().exec(new String[] { firefoxUpload, IMAGE_FILE_PATH });
		Thread.sleep(7000);
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	public void openBrowser(String browser, String url) {
		if (browser.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url);
		} else if (browser.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url);
		} else if (browser.toLowerCase().contains("safari")) {
			System.setProperty("webdriver.safari.driver", safariDriver);
			driver = new SafariDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
		}
	}

	public void clickByJScriptEx(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px groove green'", element);
		js.executeScript("arguments[0].click();", element);
	}
	public void click (String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	String workingDirectory = System.getProperty("user.dir");
	String safariDriver = workingDirectory + "//driver/SafariDriver.safariextz";
	String ADDFILE_BUTTON = "//input[@type='file']//preceding-sibling::span";
	String ADDFILE_BY_CSS = ".fileinput-button";
	
	String IMAGE_FILE_PATH = workingDirectory + "\\image\\Upload1.png";
	String firefoxUpload = workingDirectory + "//autoIT/firefox.exe";
}