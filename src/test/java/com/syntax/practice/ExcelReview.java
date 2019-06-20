package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReview {
	
	@Test
	public void readExcel() throws Exception {
		String xlPath="src/test/resources/testData/OrangeHRM.xlsx";
		 
		 FileInputStream fis=new FileInputStream(xlPath);
		 //open workbook
		 XSSFWorkbook workbook=new XSSFWorkbook(fis);
		 //open specified sheet
		 XSSFSheet sheet=workbook.getSheet("EmployeeDetails");
		 //access value specific cell
		String value= sheet.getRow(4).getCell(0).toString();
		System.out.println(value);
		//get number of rows and cols
		int rows=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getLastCellNum();
		System.out.println("Rows : "+rows+" cols : "+cols);
		//close workbook and stream
		
		
		
		
		
		workbook.close();
		fis.close();
		 
		 
	}
 
 
}
