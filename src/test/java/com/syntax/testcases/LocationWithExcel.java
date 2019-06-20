package com.syntax.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LocationPage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constant;
import com.syntax.utils.ExcelUtility;

public class LocationWithExcel extends BaseClass{

	@Test(dataProvider="Locations")
	public void AddLocation(String name,String country,String city,String zip) {
		LoginPage login=new LoginPage();
		HomePage home=new HomePage();
		AddEmployeePage addEmp=new AddEmployeePage();
		LocationPage locPage=new LocationPage();
		login.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
		CommonMethods.click(home.admin);
		CommonMethods.click(home.organize);
		CommonMethods.click(home.clickLocation);
		CommonMethods.click(home.addButon);
		//add location
		 CommonMethods.sendText(locPage.AddName,name );
		 CommonMethods.click(locPage.Loc);
		 CommonMethods.selectList(locPage.LocList, country);
		 CommonMethods.sendText(locPage.city, city );
		 CommonMethods.sendText(locPage.Zipcode, zip);
		 CommonMethods.click(locPage.saveButton);
	
			 
	}
	
	@DataProvider(name="Locations")
	public Object [][]getData(){
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constant.LOCATION_PATH, "AddLocation");
		
		int rows=obj.getRowNum();
		int cols=obj.getColNum(0);
		
		Object[][] data=new Object [rows-1][cols];
		
		for(int i=1; i<rows; i++) {
			for(int y=0; y<cols; y++) {
				String value=obj.getCellData(i, y);
				data[i-1][y]=value;
				
			}
		}
		return data;
	}
	
	@Test(groups="smoke")
	public void Verify() throws InterruptedException {
		
		Thread.sleep(4000);
		List<WebElement>rows=driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr"));
		
		
		for(WebElement row:rows) {
		String text=row.getText();
		
		AssertJUnit.assertEquals(text.contains("Arel"), true);
		System.out.println("Successful");
		
		
	
	
		}	}
}
