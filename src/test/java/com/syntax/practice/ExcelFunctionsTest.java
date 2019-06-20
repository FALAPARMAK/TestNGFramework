package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constant;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionsTest {

	@Test
	public void ExcelTest() {
		 ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constant.XL_FILEPATH, "EmployeeDetails");
		//String value = obj.getCellData(2, 3);
		//System.out.println(value);
	//retrieve all values from excell and store intoDataProvider (2D Object array)
		
		int row=obj.getRowNum();
		int cell=obj.getColNum(0);
		Object [][]data=new Object[row][cell];
		
		for(int i=0; i<row; i++) {
			for(int y=0; y<cell; y++ ) {
				//retrieve value from excel
				String valuee=obj.getCellData(i, y);
				//System.out.println(valuee);  //all value
				//store inside 	2	 array
				data[i][y]=valuee;
			}
		}
		
		System.out.println(data.length);
		 
	}
}
