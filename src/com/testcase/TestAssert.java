package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;


public class TestAssert {
	
	
	@Test
	public void testCaseIsoCode() throws InterruptedException {
		CodeProperties isoCode = CodePropertiesLookup.getCodeProperties("XDR");
		Assert.assertEquals(isoCode.getCurrencyCode(), "9601"); //---Exception
		Assert.assertEquals(isoCode.getCurrencyName(), "SDR (Special Drawing Right)");
		Assert.assertEquals(isoCode.getFractionDigits(), -1);
		Assert.assertEquals(isoCode.getSymbol(), "XDR");
		
	}
	
	@Test
	public void testCaseNumCode() {
		CodeProperties numCode = CodePropertiesLookup.getCodeProperties("414");
		Assert.assertEquals(numCode.getCurrencyCode(), "414");
		Assert.assertEquals(numCode.getCurrencyName(), "Kuwaiti Dinar");
		Assert.assertEquals(numCode.getFractionDigits(), 3);
		Assert.assertEquals(numCode.getSymbol(), "KWD");
	}

}
