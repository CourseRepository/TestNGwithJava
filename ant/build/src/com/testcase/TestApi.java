package com.testcase;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;

public class TestApi {

	public void getData() {
		CodeProperties obj = CodePropertiesLookup.getCodeProperties("AOA");
		System.out.println("Currency Code : " + obj.getCurrencyCode());
		System.out.println("Currency Name : " + obj.getCurrencyName());
		System.out.println("Fraction digit : " + obj.getFractionDigits());
		System.out.println("Sysmbol : " + obj.getSymbol());
		
	}
	
	public static void main(String[] args) {
		TestApi obj = new TestApi();
		obj.getData();

	}

}
