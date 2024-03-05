package DataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class WritingDataIntoExcel {
	
	public void writeDataIntoExcel() throws IOException {
		FileOutputStream file = new FileOutputStream
				("C:\\Users\\admin\\Documents\\SQA\\Apachi POI\\datadriventesting.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		
		for(int i=0; i<5; i++) {
			XSSFRow row = sheet.createRow(i);
			
			for(int j=0; j<3; j++) {
				row.createCell(j).setCellValue("XYZ");
			}
		}
		
		workbook.write(file);
		file.close();
		
		System.out.println("Written data into excel is Completed");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WritingDataIntoExcel w = new WritingDataIntoExcel();
		w.writeDataIntoExcel();
	}

}
