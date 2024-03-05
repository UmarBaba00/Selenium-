package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorDataDriven {

	WebDriver driver;

	@Test
	public void launchbrowser(){
		//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Invoke Chrome Browser
		driver.manage().window().maximize();

	}


	public void CalculationDataDriven() throws IOException {
		
		driver.get("https://www.moneycontrol.com/");

		//Getting Data from Excel Sheeet
		FileInputStream file = new FileInputStream
				("C:\\Users\\admin\\Documents\\SQA\\Apachi POI\\datadriventesting.xlsx");  // FileInputStream is used to open Excel fiel to read

		//Getting the WorkBook instance for XLS File
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//Get Second Sheet from WorkBook
		//		XSSFSheet sheet = workbook.getSheet("Sheet2");  // Providing Sheet name
		XSSFSheet sheet = workbook.getSheetAt(2);

		//Get First Row from the Sheet
		int rowCount = sheet.getLastRowNum();    //Get all rows from sheet or Row count
		
		for(int i=1; i<rowCount; i++) {
			
			XSSFRow current_row = sheet.getRow(i);  //First Row
			
			
			//Get One by One Cell Value
			
			XSSFCell principlecell = current_row.getCell(0);  //Locate on Principle cell
			int princ = (int)principlecell.getNumericCellValue(); //Get Numeric Value fron Principle Column  //TypeCasting
			
			XSSFCell roi = current_row.getCell(1);  //Locate on Rate of Interest cell
			int rateOfInterest = (int)roi.getNumericCellValue();//Get Numeric Value fron Rate of Interest Column
			
			XSSFCell period = current_row.getCell(2); //Locate on Rate of Period cell
			int p = (int)period.getNumericCellValue(); //Get Numeric Value fron Period Column
			
			XSSFCell frequency = current_row.getCell(3);
			String f = frequency.getStringCellValue();   //Get String Cell value from Frequency cell
			
			XSSFCell maturity = current_row.getCell(3);  //Get Cell Value
			int Exp_mvalue = (int)maturity.getNumericCellValue();  //Convert into INT and then store into a Variable
			
			
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));  //SendKey isused for TestBox which recieve only String vlaue String.valueOF convert int to String
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateOfInterest));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(p));  //String.valueOf used for sending numaric value
			
			Select periodcombo = new Select(driver.findElement(By.id("tenurePeriod")));
			periodcombo.selectByVisibleText("Year(s)");  //Select Value from DropDown using Visibility of Test
			
			Select frequency1 = new Select(driver.findElement(By.id("frequency")));
			frequency1.selectByVisibleText("Freq");
			
			driver.findElement(By.xpath(".//*['fdMatVal']/div[2]/a[1]/img")).click();  //Clicked on Calculate button
			String actual_mvalue = driver.findElement(By.xpath(".//*[@id='resp_matval']/strong")).getText(); //Value is Dynamically changes thats Why use Relative XPath
			
			if(Double.parseDouble(actual_mvalue)==Exp_mvalue) {   //Actual Value is in Desimal formate so we need to parse it into int/double 
				System.out.println("Test Passed");               //Actual value is String & Expected is INT so we need to use Double.parseDouble method
			}
			else {
				System.out.println("Test Failed");
			}
			
			driver.findElement(By.xpath(".//*['fdMatVal']/div[2]/a[2]/img")).click(); //Clear all the Values intered into text fields
		}
		
		driver.close();
		driver.quit();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		CalculatorDataDriven c = new CalculatorDataDriven();
		c.CalculationDataDriven();
		c.launchbrowser();
		
	}

}
