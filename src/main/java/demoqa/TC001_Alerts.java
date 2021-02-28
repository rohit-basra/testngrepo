package demoqa;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Alerts {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		String tabTitle = driver.getTitle();
		System.out.println("Tab Title :: "+tabTitle+"---"+driver.getCurrentUrl());
		Thread.sleep(5000);
		//driver.findElement(By.id("tabButton")).click();
		System.out.println(driver.findElement(By.xpath("//button[text()='New Window']")).getText());
		driver.findElement(By.xpath("//button[text()='New Window']")).click();;
		
		Set<String> tabs = driver.getWindowHandles();
		
		Iterator<String> itr_tab = tabs.iterator();
		String primaryTab = itr_tab.next();
		String secondaryTab = itr_tab.next();
		
		driver.switchTo().window(secondaryTab);
		tabTitle = driver.getTitle();
		System.out.println("Tab Title :: "+tabTitle+"---"+driver.getCurrentUrl());
		System.out.println(primaryTab +"----"+secondaryTab);
		driver.switchTo().window(primaryTab);
		tabTitle = driver.getTitle();
		System.out.println("Tab Title :: "+tabTitle+"---"+driver.getCurrentUrl());
		driver.close();
	}

}
