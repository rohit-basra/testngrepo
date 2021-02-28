package basicutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicUtils {

	public WebDriver driver;
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicUtils bu = new BasicUtils();
		bu.driver = bu.lauchBrowser("Firefox");
		bu.driver.get("https://facebook.com/");
		
	}*/
	
	public WebDriver lauchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.out.println("No Browser Found.....");
		}
		return driver;	
	}
	
	
}
