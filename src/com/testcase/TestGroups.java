package com.testcase;

import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;


public class TestGroups {
	
	public CodeProperties code = null;
	
	@Test(groups={"ISOCODE"})
	public void testNumericCode(){
		String isoCode[] = {"AOA","XOF","XDR","KWD","CLF","CHW","SSP","CLF","CHW","UYI","XBB","XBC"};
		String expected[] = {"973","952","960","414","990","948","728","990","948","940","956","957"};
		String actual[] = new String[isoCode.length];
		
		for(int i = 0; i<isoCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			actual[i] = code.getCurrencyCode();
		}
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(groups={"ISOCODE"})
	public void testMinorUnit(){
		String isoCode[] = {"AOA","XOF","XDR","KWD","CLF","CHW","SSP","CLF","CHW","UYI","XBB","XBC"};
		int expected[] = {2,0,-1,3,0,2,2,0,2,0,-1,-1};
		int actual[] = new int[isoCode.length];
		
		for(int i = 0; i<isoCode.length; i++){
			code = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			actual[i] = code.getFractionDigits();
		}
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(groups={"LOCALE"})
	public void testLocaleName(){
		Locale[] locale = {Locale.CANADA,Locale.CHINA,Locale.FRANCE,Locale.KOREA};
		String expected[] = {"Canadian Dollar","Yuan Renminbi","Euro","Won"};
		String actual[] = new String[locale.length];
		
		for(int i = 0; i<locale.length; i++){
			code = CodePropertiesLookup.getCodeProperties(locale[i]);
			actual[i] = code.getCurrencyName();
		}
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(groups={"GRP"})
	public void testLocaleName2(){
		Locale[] locale = {Locale.CANADA,Locale.CHINA,Locale.FRANCE,Locale.KOREA};
		String expected[] = {"Canadian Dollar","Yuan Renminbi","Euro","Won"};
		String actual[] = new String[locale.length];
		
		for(int i = 0; i<locale.length; i++){
			code = CodePropertiesLookup.getCodeProperties(locale[i]);
			actual[i] = code.getCurrencyName();
		}
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(groups={"LOCALE"},dependsOnGroups={"ISOCODE","GRP"})
	public void testLocaleSymbol(){
		Locale[] locale = {Locale.CANADA,Locale.CHINA,Locale.FRANCE,Locale.KOREA};;
		String expected[] = {"CAD","CNY","EUR","KRW"};
		String actual[] = new String[locale.length];
		
		for(int i = 0; i<locale.length; i++){
			code = CodePropertiesLookup.getCodeProperties(locale[i]);
			actual[i] = code.getSymbol();
		}
		
		Assert.assertEquals(actual, expected);
	}

}
