package revisionwork.revisionwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basicutils.BasicUtils;

public class TC001_WorkingWithInput {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		BasicUtils bu = new BasicUtils();
		driver = bu.lauchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3000);
		WebElement userName = driver.findElement(By.id("txtUsername"));//.sendKeys("Admin");
		userName.sendKeys("Admin");
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

}
