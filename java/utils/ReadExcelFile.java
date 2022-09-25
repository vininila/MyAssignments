package utils;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static String[][] readData(String fileName) throws IOException {
		XSSFWorkbook book=new XSSFWorkbook("./Data/"+fileName+".xlsx");
		XSSFSheet sheet = book.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(1).getLastCellNum();
		String[][] data=new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				
				String allValues = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(allValues);
				data[i-1][j]=allValues;
				
			}
			
		}
		book.close();//to close the current workbook 
		return data;

	}

}
