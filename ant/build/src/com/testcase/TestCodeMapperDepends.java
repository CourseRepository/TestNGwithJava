package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;


public class TestCodeMapperDepends extends Assert {
	
	
	public CodeProperties code = null;
	
	
	public String numCode[] = null; //expected for testNumericCode method
	public int fdigit[] = null; //expected for testMinorCode Method
	public String curName[] = null; //expected for testCurrencyName method
	
	
	@Test
	public void testSymbol(){
		String isoCode[] = {"AOA","XOF","XDR","KWD","CLF","CHW","SSP","CLF","CHW","UYI","XBB","XBC"};
		String expected[] = {"AOA","XOF","XDR","KWD","CLF","CHW","SSP","CLF","CHW","UYI","XBB","XBC"};
		String actual[] = new String[isoCode.length];
		numCode = new String[isoCode.length];
		
		for(int i = 0; i< isoCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			actual[i] = code.getSymbol();
			numCode[i] = code.getCurrencyCode();
		}
		
		assertEquals(actual, expected);
	}
	
	@Test(dependsOnMethods={"testSymbol"})
	public void testNumericCode(){
		String isoCode[] = {"AOA","XOF","XDR","KWD","CLF","CHW","SSP","CLF","CHW","UYI","XBB","XBC"};
		String actual[] = new String[isoCode.length];
		fdigit = new int[isoCode.length];
		
		for(int i = 0; i< isoCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			actual[i] = code.getCurrencyCode();
			fdigit[i] = code.getFractionDigits();
		}
		
		assertEquals(actual, numCode);
	}
	
	@Test(dependsOnMethods={"testNumericCode"})
	public void testMinorUnit(){
		String isoCode[] = {"AOA","XOF","XDR","KWD","CLF","CHW","SSP","CLF","CHW","UYI","XBB","XBC"};
		int actual[] = new int[isoCode.length];
		curName = new String[isoCode.length];
		
		for(int i = 0; i< isoCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			actual[i] = code.getFractionDigits();
			curName[i] = code.getCurrencyName();
		}
		assertEquals(actual, fdigit);
	}
	
	@Test(dependsOnMethods={"testNumericCode","testMinorUnit"},invocationCount=1)
	public void testAll(){
		String isoCode[] = {"AOA","XOF","XDR","KWD","CLF","CHW","SSP","CLF","CHW","UYI","XBB","XBC"};
		for(int i = 0; i< isoCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			assertEquals(numCode[i], code.getCurrencyCode());
			assertEquals(fdigit[i], code.getFractionDigits());
			assertEquals(curName[i], code.getCurrencyName());
		}
		assertEquals("a", "b");
	}

}
