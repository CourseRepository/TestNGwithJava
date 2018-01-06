package com.testcase;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestListner extends Assert {
	
	@Test
	public void testCaseFail() {
		fail("Fail");
	}
	
	@Test
	public void testCasePass() {
		assertTrue(true);
		
	}
	
	@AfterMethod
	public void getStatus(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS){
			System.out.println("Success =  Method Status : " + result.getStatus() + " : Method Name :" + result.getMethod().getMethodName());
		}
		if(result.getStatus() == ITestResult.FAILURE){
			System.out.println("Failed =  Method Status : " + result.getStatus() + " : Method Name :" + result.getMethod().getMethodName());		}
	}

}
