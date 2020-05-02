package com.testcase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomeITestListener implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		System.err.println("=======onFinish Test Method Name=========");
		ITestNGMethod []name = arg0.getAllTestMethods();
		
		for(ITestNGMethod obj : name){
			System.out.println("Test Method Name : " + obj.getMethodName());
		}
		
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("onStart Test Name : " + arg0.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("onTestFailure Test Method Name : " + arg0.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("onTestStart Test Method Name : " + arg0.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("onTestSuccess Test Method Name : " + arg0.getMethod().getMethodName());
		
	}

}
