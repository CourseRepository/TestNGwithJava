package com.testcase;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class TestParallesim {
	
	@Test
	public void testCase1(Method name) throws Exception {
					
		
	}
	
	@Test
	public void testCase2(Method name) {
		System.err.println("Method Name : " + name.getName());
		
		
	}
	
	
	@Test
	public void testCase3(Method name) {
		System.err.println("Method Name : " + name.getName());
		
		
	}
	
	
	@Test
	public void testCase4(Method name) {
		System.err.println("Method Name : " + name.getName());
		
		
	}

}
