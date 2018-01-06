package com.testcase;

import org.testng.annotations.Test;

import com.api.CodeProperties;
import com.api.CodePropertiesLookup;
import com.customeassert.CustomeVerify;

public class TestCustomeAssert {
	
	@Test
	public void testCaseIsoCode() throws InterruptedException {
		CodeProperties isoCode = CodePropertiesLookup.getCodeProperties("XDR");
		CustomeVerify.verifyEqual(isoCode.getCurrencyCode(), "9601"); //---Exception
		CustomeVerify.verifyEqual(isoCode.getCurrencyName(), "SDR (Special Drawing Right)");
		CustomeVerify.verifyEqual(isoCode.getFractionDigits(), -1);
		CustomeVerify.verifyEqual(isoCode.getSymbol(), "XDR");
		
	}

}
