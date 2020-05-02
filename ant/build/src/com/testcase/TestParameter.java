package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;


public class TestParameter extends Assert {
	
	private CodeProperties prop = null;
	
	@Test(description="Will Take Iso Code value as parameter")
	@Parameters(value={"isoCode"})
	public void testCaseIsoCode(String isoCode) {
		prop = CodePropertiesLookup.getCodeProperties(isoCode);
		assertEquals(prop.getCurrencyCode(), "9601"); //---Exception
		assertEquals(prop.getCurrencyName(), "SDR (Special Drawing Right)");
		assertEquals(prop.getFractionDigits(), -1);
		assertEquals(prop.getSymbol(), "XDR");
	}
	
	
	@Test(description="Will take numeric code as parameter")
	@Parameters(value={"numCode"})
	public void testCaseNumCode(String numCode) {
		prop = CodePropertiesLookup.getCodeProperties(numCode);
		assertEquals(prop.getCurrencyCode(), "414");
		assertEquals(prop.getCurrencyName(), "Kuwaiti Dinar");
		assertEquals(prop.getFractionDigits(), 3);
		assertEquals(prop.getSymbol(), "KWD");
	}
	
	@Test(description="Will Take multiple parameter")
	@Parameters(value={"isoCode","numCode"})
	public void testCaseMultiParament(String code,String num) {
		System.out.println("Parameter One : " + code);
		System.out.println("Parameter Two : " + num);
	}
	
	@Test(description="Will Take multiple parameter")
	@Parameters(value={"multi"})
	public void testCaseMultiParamentTwo(String code) {
		String value[] = code.split(",");
		for(int i = 0; i < value.length; i++){
			System.out.println("Parameter One : " + value[i]);
		}
		
	}

}
