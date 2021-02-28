package revisionwork.revisionwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basicutils.BasicUtils;

public class TC002_WorkingWithLinks {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		boolean flag = true;
		BasicUtils bu =  new BasicUtils();
		driver = bu.lauchBrowser("Chrome");
		
		driver.get("https://www.spicejet.com/");

		List<WebElement> aTags = driver.findElements(By.tagName("a"));
		
		System.out.println("Count of <a> Tags :: "+aTags.size());
		int n = 1;
		for (int i = 0; i < aTags.size(); i++) {
			String tags = aTags.get(i).getText();
			//System.out.println(i+") - "+tags);
			if(!tags.isEmpty()) {
				System.out.println(n+") - "+tags);
				n++;
			}	
		}
	}

}
