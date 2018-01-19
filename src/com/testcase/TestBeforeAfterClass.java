package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;

public class TestBeforeAfterClass extends Assert {
	
	public CodeProperties code = null;
	public String[][] expectedResult = null;
	public String msg = "";
	
	@BeforeClass
	public void setUp() {
		System.err.println("+++++++++++++++++Before Class+++++++++++");
		expectedResult = new String[6][4];

		expectedResult[0][0] = "AOA";
		expectedResult[0][1] = "973";
		expectedResult[0][2] = "2";
		expectedResult[0][3] = "Kwanza";

		expectedResult[1][0] = "XOF";
		expectedResult[1][1] = "952";
		expectedResult[1][2] = "0";
		expectedResult[1][3] = "CFA Franc BCEAO";

		expectedResult[2][0] = "XDR";
		expectedResult[2][1] = "960";
		expectedResult[2][2] = "-1";
		expectedResult[2][3] = "SDR (Special Drawing Right)";

		expectedResult[3][0] = "KWD";
		expectedResult[3][1] = "414";
		expectedResult[3][2] = "3";
		expectedResult[3][3] = "Kuwaiti Dinar";

		expectedResult[4][0] = "CLF";
		expectedResult[4][1] = "990";
		expectedResult[4][2] = "0";
		expectedResult[4][3] = "Unidad de Fomento";

		expectedResult[5][0] = "CHW";
		expectedResult[5][1] = "948";
		expectedResult[5][2] = "2";
		expectedResult[5][3] = "WIR Franc";

	}
	
	@Test
	public void testIsoCode(){
		System.out.println("==============testIsoCode============");
		String isoCode[] = {"AOA","XOF","XDR","KWD","CLF","CHW"};
		
		for(int i = 0; i<isoCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			assertEquals(code.getSymbol(), expectedResult[i][0]);
			assertEquals(code.getCurrencyCode(), expectedResult[i][1]);
			assertEquals(code.getFractionDigits(),Integer.parseInt((expectedResult[i][2])));
			assertEquals(code.getCurrencyName(), expectedResult[i][3]);
		}
	}
	
	@Test
	public void testNumCode(){
		System.out.println("==============testNumCode============");
		String numCode[] = {"973","952","960","414","990","948"};
		
		for(int i = 0; i<numCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(numCode[i]);
			assertEquals(code.getSymbol(), expectedResult[i][0]);
			assertEquals(code.getCurrencyCode(), expectedResult[i][1]);
			assertEquals(code.getFractionDigits(),Integer.parseInt((expectedResult[i][2])));
			assertEquals(code.getCurrencyName(), expectedResult[i][3]);
		}
	}
	
	@AfterClass
	public void tearDown(){
		System.err.println("+++++++++++++++++After Class+++++++++++");
		expectedResult = null;
	}


}
