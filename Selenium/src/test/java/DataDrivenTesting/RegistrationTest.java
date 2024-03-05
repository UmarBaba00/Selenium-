package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTest {


	WebDriver driver;

	@Test
	public void launchbrowser(){
		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();

	}


	public void RegistrationDataDriven() throws IOException {
		
		driver.get("http://newtours.demoaut.com/");

		//Getting Data from Excel Sheeet
		FileInputStream file = new FileInputStream
				("C:\\Users\\admin\\Documents\\SQA\\Apachi POI\\datadriventesting.xlsx");  // FileInputStream is used to open Excel fiel to read

		//Getting the WorkBook instance for XLS File
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//Get Second Sheet from WorkBook
		//		XSSFSheet sheet = workbook.getSheet("Sheet2");  // Providing Sheet name
		XSSFSheet sheet = workbook.getSheetAt(1);

		//Get First Row from the Sheet
		int noOfRows = sheet.getLastRowNum();    //Get all rows from sheet or Row count

		System.out.println("No of Records in the Excel Sheet:" + noOfRows);
		
		for(int row=1; row<noOfRows; row++) {
			
			XSSFRow current_row = sheet.getRow(row);  //First Row
			
			String First_name = current_row.getCell(0).getStringCellValue();
			String Last_name = current_row.getCell(1).getStringCellValue();
			String Phone = current_row.getCell(2).getStringCellValue();
			String Email = current_row.getCell(3).getStringCellValue();
			String Address = current_row.getCell(4).getStringCellValue();
			String City = current_row.getCell(5).getStringCellValue();
			String State = current_row.getCell(6).getStringCellValue();
			String Postal_Code = current_row.getCell(7).getStringCellValue();
			String Country = current_row.getCell(8).getStringCellValue();
			String UserName = current_row.getCell(9).getStringCellValue();
			String Password = current_row.getCell(10).getStringCellValue();
			
			//Registration Process
			driver.findElement(By.linkText("REGISTER")).click();
			
			//Entering Contact Information
			driver.findElement(By.name("firstName")).sendKeys(First_name);
			driver.findElement(By.name("lastName")).sendKeys(Last_name);
			driver.findElement(By.name("phone")).sendKeys(Phone);
			driver.findElement(By.name("userName")).sendKeys(Email);
			
			//Entering Mailing Information
			driver.findElement(By.name("address1")).sendKeys(Address);
			driver.findElement(By.name("address2")).sendKeys(Address);
			driver.findElement(By.name("city")).sendKeys(City);
			driver.findElement(By.name("state")).sendKeys(State);
			driver.findElement(By.name("postalCode")).sendKeys(Postal_Code);
			
			//Country Selection
			Select dropcountry = new Select(driver.findElement(By.name("Country")));
			dropcountry.selectByVisibleText(Country);
			
			//Entring User Information
			driver.findElement(By.name("email")).sendKeys(Email);
			driver.findElement(By.name("password")).sendKeys(Password);
			driver.findElement(By.name("confirmPassword")).sendKeys(Password);
			
			//Submitting Form
			driver.findElement(By.name("register")).click();
			
			if(driver.getPageSource().contains("Tank you for registring")) {
				System.out.println("Registration completed for " + row + "record");
			}
			else {
				System.out.println("Registration failed for " + row + "record");
			}
		}
		System.out.println("Data Driver Test Completed");
		driver.close();
		driver.quit();
		file.close();   //Close Excel File
		
//		int colcount = sheet.getRow(0).getLastCellNum(); // Returns Column/cell Count
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		RegistrationTest r = new RegistrationTest();
		r.launchbrowser();
		r.RegistrationDataDriven();
	}

}
