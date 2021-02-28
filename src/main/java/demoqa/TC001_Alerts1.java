package demoqa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Alerts1 {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		
		/*driver.findElement(By.id("alertButton")).click();
		
		Alert b1 = driver.switchTo().alert();
		String alertText = b1.getText();
		System.out.println(alertText);
		b1.accept();*/

		/*driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(6000);
		Alert b2 = driver.switchTo().alert();
		String alertText2 = b2.getText();
		System.out.println(alertText2);
		b2.accept();*/
		
		/*//Error Implicit Wait Does Not Work
		 driver.findElement(By.id("timerAlertButton")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Alert b2 = driver.switchTo().alert();
		String alertText2 = b2.getText();
		System.out.println(alertText2);
		b2.accept();*/
		
		driver.findElement(By.id("timerAlertButton")).click();
		/*WebDriverWait expWait = new WebDriverWait(driver, 6);
		expWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("timerAlertButton"))));*/
	
		
	}

}
