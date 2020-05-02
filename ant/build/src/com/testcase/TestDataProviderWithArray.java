package com.testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProviderWithArray {
	
	@DataProvider(name="getArrayData")
	public Object[][] getArrayData() {
		String[] intary = {"A","B","C","D","E"};
		Object[][] objAry = new Object[1][1];
		objAry[0][0] = intary;
		return objAry;
	}
	
	@Test(description="To supply array in dataprovider",dataProvider="getArrayData")
	public void testArryData(String []args) {
		for (int i = 0; i <args.length; i++) {
			System.out.println("Args :" + args[i]);
		}
		
	}

}
