package testng;

import org.testng.annotations.Test;
//Test Cases execute in Alphabet orders 
public class Pro001_SimpleTest {

	@Test
	public void init() {
		System.out.println("This is init...");
	}
	
	@Test
	public void display01() {
		System.out.println("This is display-01...");
	}
	
	@Test
	public void display02() {
		System.out.println("This is display-02...");
	}
	
	@Test
	public void destory() {
		System.out.println("This is Destroy...");
	}
}
