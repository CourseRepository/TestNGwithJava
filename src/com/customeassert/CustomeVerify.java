package com.customeassert;

import org.testng.Assert;
import org.testng.Reporter;

public class CustomeVerify extends Assert {
	
	public static void verifyEqual(String actual,String expected) {
		try {
				assertEquals(actual, expected);
		} catch (Error e) {
			Reporter.log("Error : " + e.getLocalizedMessage());
		}
		
	}
	
	public static void verifyEqual(int actual,int expected) {
		try {
				assertEquals(actual, expected);
		} catch (Error e) {
			Reporter.log("Error : " + e.getLocalizedMessage());
		}
		
	}

}
