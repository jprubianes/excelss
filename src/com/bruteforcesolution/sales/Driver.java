package com.bruteforcesolution.sales;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Driver {
static WebDriver driver;
static Xls_Reader excelfile = new Xls_Reader("C:\\Excelf\\ProjectTestCases.xlsx");
static Xls_Reader excelfile1 = new Xls_Reader("C:\\Excelf\\testresult.xlsx");
static Homepage objhp;
static Loginpage objlp;
static String color;
static String status;


	public static void main(String[] args) throws IOException {
		String brdata = excelfile.getCellData("Sheet1", 5, 3);
		System.out.println("the data is: " + brdata);
		
		if(brdata.equals("Firefox")){
			driver =   new FirefoxDriver();
			driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			objhp = new Homepage(driver);
			objhp.signinlink();
			objlp = new Loginpage(driver);
			objlp.createacc(excelfile.getCellData("Sheet1", 4, 3));
			color = objlp.validatecolor();
			if(color.contains("rgba(235, 241, 242, 1)")){
				String status = "Pass";
			}
			else {
				String status = "Fail";
			}
			
			//Sheet s = excelfile.wb.getSheet("Sheet1");
			//s.getRow(3).getCell(3).setCellValue("pass");
			excelfile1.createWorkbook("testresult.xlsx", "Sheet1");
			excelfile1.setResultData("Summary", 3, 3, status);
			driver.close();
		}
		else if(brdata.equals("IE")){
			System.setProperty("webdriver.ie.driver","C:\\bfs\\IEDriverServer.exe");
			driver =   new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
		}
		else if(brdata.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\bfs\\chromedriver.exe");
			driver =   new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
		}
		else{
			System.out.println("Browser not supported");
		}

	}

}
