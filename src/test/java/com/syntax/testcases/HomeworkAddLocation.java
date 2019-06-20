package com.syntax.testcases;




import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LocationPage;
import com.syntax.pages.LoginPage;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constant;
import com.syntax.utils.ExcelUtility;

public class HomeworkAddLocation extends CommonMethods{

	
	@Test
	public void ALogin() {
		LoginPage login=new LoginPage();
		login.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
		
	}
	
	@Test(dataProvider="Employee Data")
	public void Location(String name,String state,String city,String zip ) throws InterruptedException {
		
	

	
	
	LocationPage locPage=new LocationPage();
	HomePage home=new HomePage();
	CommonMethods.click(home.admin);
	CommonMethods.click(home.organize); 
	CommonMethods.click(home.clickLocation);
	CommonMethods.click(home.addButon);
	
	CommonMethods.sendText(locPage.AddName, name);
	CommonMethods.click(locPage.Loc);
	CommonMethods.waitForElementBeClickable(locPage.LocList, 30);
	CommonMethods.selectList(locPage.LocList,state );
	CommonMethods.sendText(locPage.city,city );
	CommonMethods.sendText(locPage.Zipcode, zip); 
	CommonMethods.click(locPage.saveButton);
	}
	 
	
	
	
	@DataProvider(name="Employee Data")
	public Object[][] getLocationData(){
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constant.XL_FILEPATH, "EmployeeDetails");
		
		int rows=obj.getRowNum();
		int cols=obj.getColNum(0);
		
		Object[][] data=new Object[rows-1][cols];
		
		for(int i=1; i<rows; i++) {
			for(int y=0; y<cols; y++) {
				String value=obj.getCellData(i, y);
				data[i-1][y]=value;
			}
		}
		
		return data;
		
	}
	
	
	
	@Test(dependsOnMethods="AddLocation")
	public void verify() throws InterruptedException {
		
		Thread.sleep(4000);
		List<WebElement>rows=driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr"));
		
		
		for(WebElement row:rows) {
		String text=row.getText();
		
		AssertJUnit.assertEquals(text.contains("Asha"), true);
		System.out.println("Successful");
		
			}
		}
		
	
	
	
}
