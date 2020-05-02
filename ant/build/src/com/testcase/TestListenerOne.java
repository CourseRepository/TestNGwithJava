package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(value=CustomeListener.class)
public class TestListenerOne extends Assert {
	
	@Test
	public void testCasOne() {
		System.out.println("testCasOne");
		
	}
	
	
	

}
