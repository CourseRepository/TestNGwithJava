package com.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBeforeAfter {
	
	@BeforeSuite
	public void beforeTesSuitetMethod() {
		System.out.println("==================Before Suite==========");
	}
	
	@AfterSuite
	public void afterTestSuiteMethod() {
		System.out.println("==================After Suite==========");
	}
	
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("==================Before Test==========");
	}
	
	@AfterTest
	public void afterTestMethod() {
		System.out.println("==================After Test==========");
	}
	
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("==================Before Class==========");
	}
	
	@AfterClass
	public void afterAfterMethod() {
		System.out.println("==================After Class==========");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("==================Before Method==========");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("==================After Method==========");
	}
	
	
	@Test
	public void testCaseOne() {
		System.out.println("Test Case One");
	}
	
	@Test
	public void testCaseTwo() {
		System.out.println("Test Case Two");
	}

}
