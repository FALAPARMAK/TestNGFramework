package com.syntax.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.Constant;
import com.syntax.utils.ExcelUtility;

public class ExcelLoginTest  extends BaseClass{

	@Test(dataProvider="login")
	public  void Login(String url,String username, String password) {
		LoginPage login=new  LoginPage();
		driver.get(url);
		
	}
	
	@DataProvider(name="login")
	public void getData() {
		ExcelUtility excel=new ExcelUtility();
		excel.openExcel(Constant.LOGINEXCEL, "Login");
		int rows=excel.getRowNum();
		int cols=excel.getColNum(0);
		
		
		
		Object [] [] data=new Object [rows-1][cols];// I dont want to get header
		
		for(int i=1;  i<rows; i++) {
			for(int j=0; j<cols; j++) {
				String  value=excel.getCellData(i, j);
				data[i-1][j]=value;//data starts 0,0
			}
		}
	
	}
	
	
}
