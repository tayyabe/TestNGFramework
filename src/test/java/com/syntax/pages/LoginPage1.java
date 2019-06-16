package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utills.BaseClass;
import com.syntax.utills.CommonMethods;

public class LoginPage1 extends BaseClass{
	
@FindBy(id="txtUsername")
public WebElement userName;

@FindBy(name="txtPassword")
public WebElement password;
 
@FindBy(id="btnLogin")
public WebElement loginBtn;

@FindBy(css="img[src*'logo.png]")
public WebElement logo;


public LoginPage1() {
	PageFactory.initElements(driver, this);

}

public void login(String uname, String pwd) {
    CommonMethods.sendText(userName, uname);
    CommonMethods.sendText(password, pwd);
    CommonMethods.click(loginBtn);
}
}
