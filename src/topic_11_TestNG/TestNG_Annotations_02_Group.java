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

public class TestNG_Annotations_02_Group {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@BeforeClass
	public void beforeClass() {
		 System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		 System.out.println("After Class");
	}

	@BeforeTest
	public void beforeTest() {
		 System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
		 System.out.println("After Test");
	}

	@BeforeSuite
	public void beforeSuite() {
		 System.out.println("Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	@Test (groups= "candy")
	public void testCase01() {
		System.out.println("Test case 01");
	}
	@Test(groups= "cake")
	public void testCase02() {
		System.out.println("Test case 02");
	}
	@Test(groups= "candy")
	public void testCase03() {
		System.out.println("Test case 03");
	}
	@Test (groups = "cake")
	public void testCase04() {
		System.out.println("Test case 04");
	}
	@Test(groups= "syrup")
	public void testCase05() {
		System.out.println("Test case 05");
	}
	@Test(groups = "syrup")
	public void testCase06() {
		System.out.println("Test case 06");
	}
}
