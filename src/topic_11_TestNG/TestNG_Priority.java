package topic_11_TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_Priority {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@Test(priority = 3)
	public void testCase01() {
		System.out.println("Test case 01");
	}

	@Test (priority = 2, enabled =  false)
	public void testCase02() {
		System.out.println("Test case 02");
	}

	@Test(priority = 1)
	public void testCase03() {
		System.out.println("Test case 03");
	}

	@Test
	public void testCase04() {
		System.out.println("Test case 04");
	}

	@Test (enabled = false)
	public void testCase05() {
		System.out.println("Test case 05");
	}

	@Test
	public void testCase06() {
		System.out.println("Test case 06");
	}
}
