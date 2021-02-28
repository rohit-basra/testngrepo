package testng;

import org.testng.annotations.Test;
//if not @Test annotation the test case will be ignored
//if not priority on test case that test case will execute first
//the @Test annotation with -ve priority will execute first that +ve priority
public class Pro002_SimpleTest {

	@Test(priority=1)
	public void init() {
		System.out.println("This is init...");
	}
	
	@Test(priority=02)
	public void display01() {
		System.out.println("This is display-01...");
	}
	
	@Test(priority=3)
	public void display02() {
		System.out.println("This is display-02...");
	}
	
	@Test(priority=4)
	public void destory() {
		System.out.println("This is Destroy...");
	}
	
	@Test
	public void destory1() {
		System.out.println("This is Destroy1...");
	}
}
