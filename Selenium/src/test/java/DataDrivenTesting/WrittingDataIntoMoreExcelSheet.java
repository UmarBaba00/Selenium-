	package DataDrivenTesting;

	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.*;

	public class WrittingDataIntoMoreExcelSheet {
		
		public void writeDataIntoExcel() throws IOException {
			FileOutputStream file = new FileOutputStream
					("C:\\Users\\admin\\Documents\\SQA\\Apachi POI\\datadriventesting.xlsx");
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet1 = workbook.createSheet("Data1");
			XSSFSheet sheet2 = workbook.createSheet("Data2");
			
			for(int i=0; i<5; i++) {
				XSSFRow row1 = sheet1.createRow(i);
				XSSFRow row2 = sheet2.createRow(i);
				
				for(int j=0; j<3; j++) {
					row1.createCell(j).setCellValue("XYZ");
					row2.createCell(j).setCellValue("ABC");
				}
			}
			
			workbook.write(file);
			file.close();
			
			System.out.println("Written data into excel is Completed");
		}

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub

			WrittingDataIntoMoreExcelSheet w = new WrittingDataIntoMoreExcelSheet();
			w.writeDataIntoExcel();
		}

	}
