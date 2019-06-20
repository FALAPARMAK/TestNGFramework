package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {

	
	@Test
	public void writeExcel() throws IOException {
	String xlPath="src/test/resources/testData/OrangeHRM.xlsx";
	 
	 FileInputStream fis=new FileInputStream(xlPath);
	 //open workbook
	 XSSFWorkbook wbook=new XSSFWorkbook(fis);
	XSSFSheet sheet= wbook.getSheet("EmployeeDetails");
	
	//write to some values
	sheet.getRow(4).createCell(4).setCellValue("Result");
	sheet.getRow(1).createCell(4).setCellValue("Pass");
	sheet.getRow(1).getCell(4).setCellValue("fail");
	sheet.createRow(11).createCell(0).setCellValue("Mehmet");
	sheet.getRow(11).createCell(1).setCellValue("M");
	sheet.getRow(11).createCell(2).setCellValue("Can");
	sheet.getRow(11).createCell(3).setCellValue("NorthOffice");
	
	//write to excel
	FileOutputStream fos=new FileOutputStream(xlPath);
	wbook.write(fos);
	//close file and opened streams
	
	fos.close();
	wbook.close();
	fis.close();
	
	 
	 
	
	}
	
	
}
