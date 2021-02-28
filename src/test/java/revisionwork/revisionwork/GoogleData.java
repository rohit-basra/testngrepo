package revisionwork.revisionwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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

public class GoogleData {

	WebDriver driver;
	//ArrayList<String> data;
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
	
	@BeforeTest
	public void readData() throws IOException, InterruptedException {
		 String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\";
		 GoogleData objExcelFile = new GoogleData();
	     data = objExcelFile.readExcel(filePath,"StaplesAdd.xlsx","Sheet1");
	     for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
	@Test(priority=1)
	//@DataProvider
	public Object[] readExcel(String filePath,String fileName,String sheetName)throws IOException {
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
	            //System.out.println(data);
	           data1[i]=data;
	        }
	    } 
	    	return data1;
	}  
	@Test(priority=2)
	//@Test(dataProvider = "readExcel")
	public void urlpart() throws InterruptedException {
		//ArrayList<String> dataok = new ArrayList<String>();
		Object [] dataok = new Object[90];
	     for(int i=0;i<data.length;i++) {
	        	if(!data[i].equals("")) {
	        		//System.out.println(data.get(i));
	        		//dataok.add(data[i]);
	        		dataok[i] = data[i];
	        	}
	     }
	     for(int i=0;i<dataok.length;i++) {
				driver.findElement(By.id("searchboxinput")).sendKeys(""+dataok[i]);
				Thread.sleep(4000);
				driver.findElement(By.id("searchbox-searchbutton")).click();
				Thread.sleep(5000);
				String url = driver.getCurrentUrl();
				String urls[] = url.split("@");
				String newurl = urls[1];
				String splurl[] = newurl.split(",");
				System.out.println(splurl[0]+"--"+splurl[1]+"--"+splurl[2]);
			}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
