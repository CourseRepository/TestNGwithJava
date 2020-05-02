package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;




public class TestAlwaysRun {
	
	
	public CodeProperties code = null;
	
	@Test
	public void test() {
		System.out.println("Modified Test");
	}
	
	@Test(description="test")
	public void testNumericCode(){
		System.out.println("+==============testNumericCode============+");
		String isoCode[] = {"AOA","XOF","XDR","KWD","CLF","CHW","SSP","CLF","CHW","UYI","XBB","XBC"};
		String expected [] = {"973","952","960","414","990","948","728","990","948","940","956","957"};
		String actual[] = new String[isoCode.length];
		
		for(int i = 0; i < isoCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			actual[i] = code.getCurrencyCode();
		}
		
		Assert.assertEquals(actual, expected);
		Assert.assertEquals("a", "b");
	}
	
	@Test(dependsOnMethods={"testNumericCode"},alwaysRun=true)
	public void testCurrencyName(){
		System.out.println("+==============testCurrencyName============+");
		String isoCode[] = {"AOA","XOF","XDR","KWD","CLF","CHW","SSP","CLF","CHW","UYI","XBB","XBC"};
		String expected [] = {"Kwanza","CFA Franc BCEAO","SDR (Special Drawing Right)","Kuwaiti Dinar","Unidad de Fomento","WIR Franc","South Sudanese Pound","Unidad de Fomento","WIR Franc","Uruguay Peso en Unidades Indexadas (URUIURUI)","Bond Markets Unit European Monetary Unit (E.M.U.-6)","Bond Markets Unit European Unit of Account 9 (E.U.A.-9)"};
		String actual[] = new String[isoCode.length];
		
		for(int i = 0; i < isoCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			actual[i] = code.getCurrencyName();
		}
		
		Assert.assertEquals(actual, expected);
	}

}
