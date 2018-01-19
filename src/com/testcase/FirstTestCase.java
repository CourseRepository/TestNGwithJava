package com.testcase;

import javax.swing.JFrame;

import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;


public class FirstTestCase {
	
	@Test
	public void testCaseA() throws Exception {
		JFrame frame = new JFrame("First Frame");
		frame.setLocation(100, 100);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread.sleep(10000);
	}
	
	@Test
	public void testCasegetData() {
		CodeProperties obj = CodePropertiesLookup.getCodeProperties("AOA");
		System.out.println("Currency Code : " + obj.getCurrencyCode());
		System.out.println("Currency Name : " + obj.getCurrencyName());
		System.out.println("Fraction digit : " + obj.getFractionDigits());
		System.out.println("Sysmbol : " + obj.getSymbol());
	}
	
	@Test
	public void testCasegetDataTwo() {
		CodeProperties obj = CodePropertiesLookup.getCodeProperties("XOF");
		System.out.println("Currency Code : " + obj.getCurrencyCode());
		System.out.println("Currency Name : " + obj.getCurrencyName());
		System.out.println("Fraction digit : " + obj.getFractionDigits());
		System.out.println("Sysmbol : " + obj.getSymbol());
	}

}
