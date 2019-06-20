package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDemo {
     @Test
	public void readExcel() throws IOException {
		String xlPath="src/test/resources/testData/OrangeHRM.xlsx";
		FileInputStream fis=new FileInputStream(xlPath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("EmployeeDetails");
		//accessing 2 rows 4 columns
		
		String value=sheet.getRow(1).getCell(3).toString();
		System.out.println(value);
		
		//how to find number of rows
		int rowNum=sheet.getPhysicalNumberOfRows();
		
		//how to find number of cells
		int  colNum=sheet.getRow(0).getLastCellNum();
		
		System.out.println(rowNum);
		System.out.println(colNum);
		
		//retrieve all data
		
		for(int i=1; i<rowNum; i++) {
			for(int j=0; j<colNum; j++) {
				String cellvalue=sheet.getRow(i).getCell(j).toString();
				System.out.print(cellvalue+" ");
			}
			System.out.println();
		}
		workbook.close();
		fis.close(); 
	}
	
	
	
}
