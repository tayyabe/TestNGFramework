package com.syntax.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utills.BaseClass;
import com.syntax.utills.CommonMethods;
import com.syntax.utills.ConfigsReader;

public class LoginPageTest2 extends BaseClass{
	@Test(groups="smoke")
    public void loginToOrangeHRM() {
		logger=report.createTest("Positive login");
        
        LoginPage login = new LoginPage();
        logger.info("Logging with valid crendentials");
        
        CommonMethods.sendText(login.username, "Admin");
        CommonMethods.sendText(login.password, "Oa@p1N0CcF");
        CommonMethods.click(login.btnLogin);
        
        logger.info("Verifying Dashboard");
        WebElement dash = driver.findElement(By.xpath("//li[text()=‘Dashboard’]"));
        if (dash.isDisplayed()) {
            System.out.println("You’ve login");
        } else {
            System.out.println("login failed");

        }
    }

    @Test(groups="smoke")
    public void doLogin() {
        LoginPage login = new LoginPage();
        CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
        CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
        CommonMethods.click(login.btnLogin);
        HomePage home = new HomePage();
        boolean text = home.dashboardText.isDisplayed();
        Assert.assertTrue(text);
        System.out.println("User could login");
    }

    @Test(groups="smoke")
    public void invalidLogin() {
        LoginPage login = new LoginPage();
        CommonMethods.sendText(login.username, "Admin");
        CommonMethods.sendText(login.password, "Oa@p1N0CcF");
        CommonMethods.click(login.btnLogin);

        HomePage home = new HomePage();
        boolean text = home.Invalid.isDisplayed();
        Assert.assertTrue(text);
        //System.out.println(“User could not login”);

    }
    @Test
    public void addEmployee() throws InterruptedException {
        LoginPage login = new LoginPage();
        CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
        CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
        CommonMethods.click(login.btnLogin);
        
        HomePage home = new HomePage();
        home.PIM.click();
        home.addEmployee.click();
        CommonMethods.sendText(home.firstName, "Shaban");
        CommonMethods.sendText(home.lastName, "haq");
        AddEmployeePage add=new AddEmployeePage();
        List<WebElement> list=    add.locationList.findElements(By.tagName("li"));
        for (WebElement li : list) {
            String lilText=li.getAttribute("innerHTML");
            
            if (lilText.contains("HQ")) {
                li.click();
                break;
            }
        }

        driver.findElement(By.xpath("//a[@id=‘systemUserSaveBtn’]")).click();
        Thread.sleep(9000);
    }

}
