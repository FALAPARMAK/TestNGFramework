package com.syntax.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constant;
import com.syntax.utils.ExcelUtility;

public class AddEmployeePageTest  extends CommonMethods{


	@Test(dataProvider="employee details")
	public void addEmployee(String fname,String miName,String lname, String location,String screenshots) throws InterruptedException {

		LoginPage login = new LoginPage();
		HomePage home =new HomePage();
		AddEmployeePage addEmp=new AddEmployeePage();

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
 
		CommonMethods.click(home.PIM);
		CommonMethods.click(home.addEmployee);

		CommonMethods.sendText(addEmp.firstName, fname);
		CommonMethods.sendText(addEmp.middleName, miName);
		CommonMethods.sendText(addEmp.lastName, lname);
		CommonMethods.click(addEmp.location);
		CommonMethods.selectList(addEmp.locationList, location);
		CommonMethods.click(addEmp.saveBtn);
		CommonMethods.takeScreenshot(screenshots);
		
		//verify employee added
		CommonMethods.waitForElementBeClickable(addEmp.checkEmployee, 20);
		String verfText=addEmp.checkEmployee.getText();
		 AssertJUnit.assertEquals(verfText, fname+" "+lname);
		 
		
	} 
		 @DataProvider(name="Employee Data")
		 public Object [][] getEmpData() {
			 
			 ExcelUtility obj=new ExcelUtility();
			 obj.openExcel(Constant.XL_FILEPATH, "EmployeeDetails");
			 
		int rows= obj.getRowNum();//13
		int cols=obj.getColNum(0);//4
		
		Object[][] data=new Object [rows-1][cols];//new Object [12][4]
			
		
		for(int i=1; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				String value=obj.getCellData(i, j);
                 //at first iteration data[1][0]
				
				//at last iteration data[12][3]
				data[i-1][j]=value;
			}
		}
		return data;
		 
		 } 


			@DataProvider(name = "employee details")
			public Object[][] getData() {
				
				Object[][] data=new Object[3][5];
				//1 set
				data[0][0]="John";
				data[0][1]="Snow";
				data[0][2]="White";
				data[0][3]="HQ";
				data[0][4]="screenshot1";
				
				//2 set
				data[1][0]="Jane";
				data[1][1]="Rain";
				data[1][2]="Yellow";
				data[1][3]="West Office";
				data[1][4]="screenshot2";
				//3 set
				data[2][0]="Arya";
				data[2][1]="Sunny";
				data[2][2]="Blue";
				data[2][3]="North Office";
				data[2][4]="screenshot3";
				return data;
			}
		 
		
		
}
