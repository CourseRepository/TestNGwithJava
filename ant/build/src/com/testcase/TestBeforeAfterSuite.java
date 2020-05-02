package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBeforeAfterSuite extends Assert {
	
	@BeforeSuite
	public void beforeSuite(){
		System.err.println("---------Before Suite------------");
	}
	
	
	@Test
	public void testCase1(){
		System.out.println("Test Case");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.err.println("---------After Suite------------");
	}

}
