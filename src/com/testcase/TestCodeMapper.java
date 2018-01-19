package com.testcase;

import java.util.Locale;

import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;

public class TestCodeMapper {
	
	public CodeProperties code = null;
	
	
	
	
	/*
	 * Modified By Tester 1
	 * 
	 * */
	
	/* Modified By Tester 1*/
	
	
	
	
	/* Modified By Tester 2 */
	
	
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
	
	@Test(description="User Created Locale as Argument")
	public void testUserLocale(){
		code = CodePropertiesLookup.getCodeProperties(new Locale("en","us"));
		System.out.println("Currency Code : " + code.getCurrencyCode());
		System.out.println("Currency Name : " + code.getCurrencyName());
		System.out.println("Minor Unit : " + code.getFractionDigits());
		System.out.println("Symbol : " + code.getSymbol());
		System.out.println("===========================================");
	}
	

}
