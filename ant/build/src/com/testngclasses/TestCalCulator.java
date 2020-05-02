package com.testngclasses;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalCulator {
	
	private Calculator obj;
	
	@org.testng.annotations.BeforeClass
	public void BeforeClass() {
		System.out.println("Before Class");
	}
	
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		System.out.println("After Class");
	}
	
	/*@DataProvider(name="getData")
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		
		data[0][0] = 10;
		data[0][1] = 20;
		data[0][2] = 30;
		
		data[1][0] = -10;
		data[1][1] = 20;
		data[1][2] = 30;
		
		return data;
	}*/
	
	public TestCalCulator(int a,int b,int exp){
		obj = new Calculator(a, b, exp);
	}
	
	@Test()
	public void calculatorTest() {
		//obj = new Calculator(a, b, exp);
		Assert.assertEquals(obj.getSum(), obj.exp);
	}

}
