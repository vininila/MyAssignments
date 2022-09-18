package ExcelIntegration;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnToReadExcel {

	public static void main(String[] args) throws IOException {
		//Step:1-->Created the excel sheet
        //Step:2 -->Copy the Excel file into the Project under folder
		//Step:3--->Set the path to read the required excel file
		XSSFWorkbook book=new XSSFWorkbook("./Data/Sample.xlsx");
		//Step:4-->Read the required sheet form the workbook
		XSSFSheet sheet = book.getSheet("Sheet1");
		//Step:5 Get into the row
		XSSFRow row = sheet.getRow(1);
		//Step:6 Get into the Column
		XSSFCell cell = row.getCell(0);
		//Step:7 Read the Value
		String stringCellValue = cell.getStringCellValue();
		
		System.out.println("2nd Row, 1st Value [1,0] is  "+stringCellValue);
		//to get the row count
		int rowCount = sheet.getLastRowNum();//gives the count considering first row as header and ignores that
		//to get the column count
		int colCount = row.getLastCellNum();
		 
		System.out.println("RowCount is "+rowCount+" Column Count is "+colCount);
		
		//to get all the values from excel sheet
		
		for (int i = 0; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				
				String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cellValue);
				
			}
			
		}

	}

}
