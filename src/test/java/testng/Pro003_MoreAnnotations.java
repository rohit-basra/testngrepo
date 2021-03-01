package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;;

public class Pro003_MoreAnnotations {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method....");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method....");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test....");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test....");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before Class....");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class....");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before Suite....");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite....");
	}
	
	@Test
	public void myTest() {
		System.out.println("Test...");
	}
	
	@Test
	public void myTest1() {
		System.out.println("Test...1");
	}
	
	
}
