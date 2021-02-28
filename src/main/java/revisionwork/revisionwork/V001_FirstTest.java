package revisionwork.revisionwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Without Maven only with selenium jar file
 * Function use
 * getTitle()
 * 
 * 
 */

public class V001_FirstTest {

	public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "E:\\Testing Course Video\\Software\\Installation\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			String actUrl = "https://www.studyviral.in/";
			driver.get("https://www.studyviral.in/");
			String title = driver.getTitle();
			System.out.println("Title of the Page :: "+title);

			Thread.sleep(5000);
			//Now check correct -website opened
			String expUrl = driver.getCurrentUrl();
			System.out.println("Expected URL :: "+expUrl);
			if(actUrl.equalsIgnoreCase(expUrl)) {
				System.out.println("Correct Website Opened");
			}else {
				System.out.println("Incorrect Website Opened");
			}
			Thread.sleep(5000);
			driver.close();
			driver.quit();
	}

}
