package revisionwork.revisionwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleData2 {

	WebDriver driver;
	Object []data;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.ca/maps/@43.7048525,-79.3676422,13z?hl=en");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider
	public Object[] readExcel() throws IOException{//String filePath,String fileName,String sheetName)throws IOException {
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\";
		String fileName = "StaplesAdd.xlsx";
		String sheetName = "Sheet1";
		File file =    new File(filePath+"\\"+fileName);
		
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    if(fileExtensionName.equals(".xlsx")){
	    guru99Workbook = new XSSFWorkbook(inputStream);
	    }else if(fileExtensionName.equals(".xls")){
	        guru99Workbook = new HSSFWorkbook(inputStream);
	    }
	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	    String data ="";
	    //ArrayList<String> data1 = new ArrayList<String>();
	    Object data1 [] = new Object[90];
	    for (int i = 0; i < rowCount+1; i++) {
	        Row row = guru99Sheet.getRow(i);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            data = row.getCell(j).getStringCellValue()+" ";
	           if(!data.trim().equalsIgnoreCase("")) {
	        	   System.out.println(data);
			        data1[i]=data;
	           }
	        }
	        
	    } 
	    System.out.println(data1.length);
	    	return data1;
	}  
	
	@Test(dataProvider = "readExcel")
	public void urlpart(String dataAddress) throws InterruptedException {
		System.out.println(dataAddress);
				driver.findElement(By.id("searchboxinput")).sendKeys(dataAddress);
				Thread.sleep(4000);
				driver.findElement(By.id("searchbox-searchbutton")).click();
				Thread.sleep(4000);
				String url = driver.getCurrentUrl();
				String urls[] = url.split("@");
				String newurl = urls[1];
				String splurl[] = newurl.split(",");
				System.out.println(splurl[0]+"--"+splurl[1]+"--"+splurl[2]);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
