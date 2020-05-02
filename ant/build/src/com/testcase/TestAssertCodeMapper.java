package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;




public class TestAssertCodeMapper {
	
	public CodeProperties code = null;
	
	@Test(description="Iso Code as Argument",priority=3)
	public void testIsoCode(){
		code = CodePropertiesLookup.getCodeProperties("XOF");
		Assert.assertEquals("XOF", code.getSymbol());
		Assert.assertEquals("952", code.getCurrencyCode());
		Assert.assertEquals(0, code.getFractionDigits());
		Assert.assertEquals("CFA Franc BCEAO", code.getCurrencyName());
	}
	
	@Test(priority=1)
	public void testNumericCode(){
		String numCode[] = {"973","952","960","414","990","948","728","990","948","940","956","957"};
		String expected[] = {"973","952","960","414","990","948","728","990","948","940","956","957"};
		String actual[] = new String[numCode.length];
		
		for(int i = 0; i < numCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(numCode[i]);
			actual[i] = code.getCurrencyCode();
		}
		
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(enabled=false)
	public void testCurrecyName(){
		String numCode[] = {"973","952","960","414","990","948","728","990","948","940","956","957"};
		String expected[] = {"Kwanza","CFA Franc BCEAO","SDR (Special Drawing Right)","Kuwaiti Dinar","Unidad de Fomento","WIR Franc","South Sudanese Pound","Unidad de Fomento","WIR Franc","Uruguay Peso en Unidades Indexadas (URUIURUI)","Bond Markets Unit European Monetary Unit (E.M.U.-6)","Bond Markets Unit European Unit of Account 9 (E.U.A.-9)"};
		String actual[] = new String[numCode.length];
		
		for(int i = 0; i < numCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(numCode[i]);
			actual[i] = code.getCurrencyName();
		}
		
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(enabled=true,priority=2)
	public void testMinorUnit(){
		String numCode[] = {"973","952","960","414","990","948","728","990","948","940","956","957"};
		int expected[] = {2,0,-1,3,0,2,2,0,2,0,-1,-1};
		int actual[] = new int[numCode.length];
		
		for(int i = 0; i < numCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(numCode[i]);
			actual[i] = code.getFractionDigits();
		}
		
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(timeOut=11000)
	public void testTimeout() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	

}
