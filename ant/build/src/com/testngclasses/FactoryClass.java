package com.testngclasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class FactoryClass {

	@Factory(dataProvider="getData")
	public Object[] objectFactory(int a,int b,int exp){
		Object[] factory = new Object[1];
		factory[0] = new TestCalCulator(a, b, exp);
		//factory[1] = new TestCalCulator(-10, 20, 10);
		//factory[2] = new TestCalCulator(10, -20, 30);
		return factory;
	}
	
	@DataProvider(name="getData")
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		
		data[0][0] = 10;
		data[0][1] = 20;
		data[0][2] = 30;
		
		data[1][0] = -10;
		data[1][1] = 20;
		data[1][2] = 30;
		
		return data;
	}
}
