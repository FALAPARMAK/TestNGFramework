package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class HomePage extends CommonMethods {

	@FindBy(xpath = "//li[text()='Dashboard']")
	public WebElement dashboardText;

	//span[text()='PIM']
	@FindBy(xpath="//span[contains(text(),'PIM')]")
	public WebElement PIM;

	@FindBy(xpath = "//span[text()='Add Employee']")
	public WebElement Add;

	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement fName;

	@FindBy(id = "lastName")
	public WebElement LName;
	
	 @FindBy(id="employeeId")
	    public WebElement employeeId;
	
	 @FindBy(partialLinkText="Add Employee")
	    public WebElement addEmployee;
	 
	 @FindBy(xpath="//*[@id=\"menu_admin_viewAdminModule\"]/a/span[2]")
	 public WebElement admin;
	 
	 @FindBy(xpath="//span[text()='Organization']")
	 public WebElement organize;
	 
	 @FindBy(xpath="//span[text()='Locations']")
	 public WebElement clickLocation;

	 @FindBy(xpath="//i[text()='add']")
	 public  WebElement addButon;
	 
	 
	 
	public HomePage() { 
		PageFactory.initElements(driver, this);//driver  page

	}

}
