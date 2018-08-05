package topic_03_ex_browser_element;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_script {

	WebDriver driver;
	
	String EMAIL_TEXTBOX = "//input[@id='mail']";
	String EDU_TEXTBOX = "//*[@id='edu']";
	String AGE_UNDER18_RADIO_BUTTON = "//input[@id='under_18']";
	String JOBROLE_01_DROPLIST = "//select[@id='job1']";
	String INTEREST_DEVELOP_CHECKBOX = "//input[@id='development']";
	String SLIDER01 = "//input[@id='slider-1']";
	String BUTTON_IS_ENABLE = "//button[@id='button-enabled']";
	
	String PASS_TEXTBOX = "//input[@id='password']";
	String RADIO_BUTTON_DISABLE = "//input[@id='radio-disabled']";
	String BIOGRAPHY_TEXTBOX = "//*[@id='bio']";
	String JOBROLE_02_DROPLIST = "//select[@id='job2']";
	String CHECKBOX_DISABLE = "//input[@id='check-disbaled']";
	String SlIDE02 = "//input[@id='slider-2']";
	String BUTTON_IS_DISABLE = "//button[@id='button-disabled']";
	
	  @BeforeClass
	  public void beforeClass() {
//		  System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//		  driver = new ChromeDriver();
//		  driver = new FirefoxDriver();
//		  driver.get("http://daominhdam.890m.com/");
	  }

	  @Test
	  public void TC004_RunTestcaseWithOtherBrowser() {
		  String array[] = {"Chrome","Firefox"};
		  for (int i = 0; i<2;  i++) {
			  System.out.println("This testcase bellow runs on "+array[i]+ " browser");
			  openBrowser(array[i]);
			  TC001_VerifyItemDisplay();
			  TC002_VerifyItemEnableOrDisable();
			  TC003_VerifyItemIsSelected();
			  driver.quit();
		  }
	  } 
	  
  
  public void TC001_VerifyItemDisplay() {
	  if(checkDisplay(EMAIL_TEXTBOX) && checkDisplay(EDU_TEXTBOX)) {
		  sendText(EMAIL_TEXTBOX, "Automation Testing");
	  }
	  
	  if (checkDisplay(AGE_UNDER18_RADIO_BUTTON)) {
		  click(AGE_UNDER18_RADIO_BUTTON);
	  }
	  
  }
  
  public void TC002_VerifyItemEnableOrDisable() {
	  //Check enable
	  checkEnable(EMAIL_TEXTBOX, "Email");
	  checkEnable(AGE_UNDER18_RADIO_BUTTON, "Age Under 18");
	  checkEnable(EDU_TEXTBOX, "Education");
	  checkEnable(JOBROLE_01_DROPLIST, "Job Role 01");
	  checkEnable(INTEREST_DEVELOP_CHECKBOX, "Development");
	  checkEnable(SLIDER01, "Slide 01");
	  checkEnable(BUTTON_IS_ENABLE, "Button is enable");
	  
	  //Check disable
	  checkEnable(PASS_TEXTBOX, "Pass text box");
	  checkEnable( RADIO_BUTTON_DISABLE, "Age radio button");
	  checkEnable(BIOGRAPHY_TEXTBOX, "Biography");
	  checkEnable(JOBROLE_02_DROPLIST, "Job Role 02");
	  checkEnable(CHECKBOX_DISABLE, "Check Box disable");
	  checkEnable(SlIDE02, "Slide 02");	
	  checkEnable(BUTTON_IS_DISABLE, "Button is disable");
	  
	  
  }
  
  public void TC003_VerifyItemIsSelected() {
	 click(AGE_UNDER18_RADIO_BUTTON);
	 click(INTEREST_DEVELOP_CHECKBOX);
	if( checkSelected(AGE_UNDER18_RADIO_BUTTON)) {
		System.out.println("Age is selected");
	} else {
		click(AGE_UNDER18_RADIO_BUTTON);
	}
	if(checkSelected(INTEREST_DEVELOP_CHECKBOX)) {
		System.out.println("Develop is selected");
	} else {
		click(INTEREST_DEVELOP_CHECKBOX);
	}
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
	public boolean checkDisplay(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.isDisplayed();
	}
	public void checkEnable(String xpath, String value) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if(element.isEnabled()) {
		System.out.println(value + " is Enable");
		}
		else {
		System.out.println(value + " is Disable");
		}
	}
	public boolean checkSelected (String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.isSelected();
	}
	public void openBrowser(String browser) {
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://daominhdam.890m.com/");
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
		}else if (browser.equals("Firefox")){
			driver = new FirefoxDriver();
			driver.get("http://daominhdam.890m.com/");
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
		}
	}
}
