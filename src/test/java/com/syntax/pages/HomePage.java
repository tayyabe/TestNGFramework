package com.syntax.pages;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utills.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage extends BaseClass{

	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	// path for invalid login alert text
	@FindBy(css="div[class='toast-message']")
	public WebElement Invalid;
	
	
	@FindBy(partialLinkText="PIM")
    public WebElement PIM;
	
    @FindBy(partialLinkText="Add Employee")
    public WebElement addEmployee;
	
    @FindBy(xpath="//input[@id=‘firstName’]")
    	    public WebElement firstName;
    	    
    	    @FindBy(xpath="//input[@id=‘lastName’]")
    	    public WebElement lastName;
    	    
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
}