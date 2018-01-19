package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;


public class TestDependsOnMethod extends Assert {
	
	public String code = "";
	
	@Test
	public void testCaseC() throws InterruptedException {
		//System.out.println("Name : testCaseC");
		CodeProperties isoCode = CodePropertiesLookup.getCodeProperties("XDR");
		Assert.assertEquals(isoCode.getCurrencyCode(), "960"); //---Exception
		Assert.assertEquals(isoCode.getCurrencyName(), "SDR (Special Drawing Right)");
		Assert.assertEquals(isoCode.getFractionDigits(), -1);
		assertEquals(isoCode.getSymbol(), "XDR");
		code = "414";
		fail("Failed by User");
	}
	
	@Test(dependsOnMethods={"testCaseC"})
	public void testCaseB() {
		
		CodeProperties numCode = CodePropertiesLookup.getCodeProperties(code);
		Assert.assertEquals(numCode.getCurrencyCode(), "414");
		Assert.assertEquals(numCode.getCurrencyName(), "Kuwaiti Dinar");
		Assert.assertEquals(numCode.getFractionDigits(), 3);
		Assert.assertEquals(numCode.getSymbol(), "KWD");
	}
	
	@Test(dependsOnMethods={"testCaseC"},alwaysRun=true)
	public void testCaseA() {
		
		CodeProperties numCode = CodePropertiesLookup.getCodeProperties(code);
		Assert.assertEquals(numCode.getCurrencyCode(), "414");
		Assert.assertEquals(numCode.getCurrencyName(), "Kuwaiti Dinar");
		Assert.assertEquals(numCode.getFractionDigits(), 3);
		Assert.assertEquals(numCode.getSymbol(), "KWD");
	}


}
