package revisionwork.revisionwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.select.Evaluator.IsEmpty;

import basicutils.BasicUtils;

public class GoogleTest {

	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		GoogleTest objExcelFile = new GoogleTest();

        String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\";
        ArrayList<String> data = objExcelFile.readExcel(filePath,"StaplesAdd.xlsx","Sheet1");
        ArrayList<String> dataok = new ArrayList<String>();
        for(int i=0;i<data.size();i++) {
        	if(!data.get(i).trim().isEmpty()) {
        		//System.out.println(data.get(i));
        		dataok.add(data.get(i));
        	}
        }
       /* for(int i=0;i<dataok.size();i++) {
        		System.out.println(i+" "+dataok.get(i));
        }*/
        
		// TODO Auto-generated method stub
		BasicUtils bu = new BasicUtils();
		driver = bu.lauchBrowser("chrome");
		//new ChromeDriver();
		driver.get("https://www.google.ca/maps/@43.7048525,-79.3676422,13z?hl=en");
		/*driver.findElement(By.id("searchboxinput")).sendKeys("2550 ouellette avenue windsor");;
		driver.findElement(By.id("searchbox-searchbutton")).click();;*/
		for(int i=0;i<dataok.size();i++) {
			driver.findElement(By.id("searchboxinput")).sendKeys(dataok.get(i));
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

	public ArrayList<String> readExcel(String filePath,String fileName,String sheetName)throws IOException {
		File file =    new File(filePath+"\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;
		
		 //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    guru99Workbook = new XSSFWorkbook(inputStream);

	    }else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of HSSFWorkbook class

	        guru99Workbook = new HSSFWorkbook(inputStream);

	    }
	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it
	    String data ="";
	    ArrayList<String> data1 = new ArrayList<String>();
	    for (int i = 0; i < rowCount+1; i++) {
	    	String d1 = "";
	        Row row = guru99Sheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	           // System.out.print(row.getCell(j).getStringCellValue()+" ");
	            data = row.getCell(j).getStringCellValue()+" ";
	            //System.out.println(data);
	           data1.add(data);
	        	//d1 = d1+row.getCell(j).getStringCellValue()+" ";
	        }

	        //System.out.println();
	    } 
	    	return data1;
	    }  

	
}
