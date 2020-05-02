package com.testcase;

import java.util.Locale;

import javax.swing.JFrame;

import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;

public class TestJFrame {
	
	public CodeProperties code = null;
	
	@Test
	public void testA() throws InterruptedException{
		JFrame frame = new JFrame("Test Frame");
		frame.setVisible(true);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread.sleep(1000);
	}
	@Test(description="Iso Code As Argument")
	public void testIsoCode(){
		code = CodePropertiesLookup.getCodeProperties("XCD");
		System.out.println("Currency Code : " + code.getCurrencyCode());
		System.out.println("Currency Name : " + code.getCurrencyName());
		System.out.println("Minor Unit : " + code.getFractionDigits());
		System.out.println("Symbol : " + code.getSymbol());
		System.out.println("===========================================");
	}
	
	@Test(description="Num Code as Argument")
	public void testNumCode(){
		code = CodePropertiesLookup.getCodeProperties("690");
		System.out.println("Currency Code : " + code.getCurrencyCode());
		System.out.println("Currency Name : " + code.getCurrencyName());
		System.out.println("Minor Unit : " + code.getFractionDigits());
		System.out.println("Symbol : " + code.getSymbol());
		System.out.println("===========================================");
		
		
	}
	
	@Test(description="Locale As Argumet")
	public void testLocale(){
		code = CodePropertiesLookup.getCodeProperties(Locale.CANADA);
		System.out.println("Currency Code : " + code.getCurrencyCode());
		System.out.println("Currency Name : " + code.getCurrencyName());
		System.out.println("Minor Unit : " + code.getFractionDigits());
		System.out.println("Symbol : " + code.getSymbol());
		System.out.println("===========================================");
	}

}
