package DataDrivenTesting;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadingDataFromExcel {
	
	public void ReadData() throws IOException {
		FileInputStream file = new FileInputStream
				("C:\\Users\\admin\\Documents\\SQA\\Apachi POI\\datadriventesting.xlsx");  // FileInputStream is used to open Excel fiel to read
		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		XSSFSheet sheet = workbook.getSheet("Sheet1");  // Providing Sheet name
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowcount = sheet.getLastRowNum();    //Get all rows from sheet or Row count
		
		int colcount = sheet.getRow(0).getLastCellNum(); // Returns Column/cell Count
		
		for(int i=0; i<rowcount; i++) {      //used to go through the sheet rows and columns
			XSSFRow currentrow = sheet.getRow(i);   // Focused on current row  
			
			for(int j=0; j<colcount; j++) {  // used to go through cells of sheet
				String value =currentrow.getCell(j).toString(); // Get cell from Current Row // Read the value from cell
				System.out.print("  " +value);   //space is used for formitting the output
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ReadingDataFromExcel r = new ReadingDataFromExcel();
		r.ReadData();
	}

}
