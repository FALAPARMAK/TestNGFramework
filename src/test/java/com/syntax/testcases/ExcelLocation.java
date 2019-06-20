package com.syntax.testcases;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelLocation {

	@Test
	public void  readExcel() throws IOException {
	String xlPath="src/test/resources/TestLocation/AddLocation.xlsx";	
	FileInputStream	 fis=new FileInputStream(xlPath);
	
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("AddLocation");
	String value=sheet.getRow(1).getCell(2).toString();
	System.out.println(value);
	//number of rows
	int rowNum=sheet.getPhysicalNumberOfRows();
	//number of cells
	int colNum=sheet.getRow(0).getLastCellNum();
	System.out.println(rowNum);
	System.out.println(colNum);
	for(int i=0; i<rowNum; i++) {
		for(int k=0; k<colNum; k++) {
			String allValue=sheet.getRow(i).getCell(k).toString();
			System.out.println(allValue+" ");
		}
		System.out.println();
	}
	workbook.close();
	fis.close();
	}
}
