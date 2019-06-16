package com.syntax.utills;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener{

    @Override
    public void onTestStart(ITestResult result) {
   System.out.println("Test Started: "+ result.getName()); 
   logger=report.createTest("Test case started:" +result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success: "+ result.getName());
        logger.pass("Test passed:" +result.getName());
        
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: "+ result.getName()); 
        logger.fail("Test failes:" +result.getName());
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed But With in Success Percentage: " + result.getName());

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Start: " + context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished: " + context.getName());

    }
}