package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.CommonMethods;

public class LocationPage extends CommonMethods{
	
	@FindBy(css="input[id='name']")
	 public WebElement AddName;
	 
	 @FindBy(xpath="//div[@id='countryCode_inputfileddiv']//div//input")
	 public WebElement Loc;
	 
	 @FindBy(xpath="//div[@id='countryCode_inputfileddiv']//div//ul/li")
	 public WebElement LocList;
	 
	 @FindBy(css="input[id='city']")
	 public WebElement city;
	 
	 @FindBy(css="input[id='zipCode']")
	 public WebElement Zipcode;
	 
	 @FindBy(css="a[class$='green btn primary-btn']")
	 public WebElement saveButton;
	 
	public  LocationPage(){
		PageFactory .initElements(driver, this);
	 }
	 
}
