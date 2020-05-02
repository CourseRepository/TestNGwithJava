package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;


public class TestParam {
	
public CodeProperties code = null;

	@BeforeClass
	public void beforeClass(){
		System.out.println("++++++=======TestParam===========+++++++++++");
	}
	
	@Test(description="Iso Code as Argument")
	@Parameters(value={"isoCode"})
	public void testIsoCode(String isoCode){
		System.out.println("+==============TestParam============+");
		code = CodePropertiesLookup.getCodeProperties(isoCode);
		Assert.assertEquals("XOF", code.getSymbol());
		Assert.assertEquals("952", code.getCurrencyCode());
		Assert.assertEquals(0, code.getFractionDigits());
		Assert.assertEquals("CFA Franc BCEAO", code.getCurrencyName());
	}
	
	@Test(description="Iso Code as Argument")
	@Parameters(value={"numCode"})
	public void testNumCode(String numCode){
		System.out.println("+==============TestParam============+");
		code = CodePropertiesLookup.getCodeProperties(numCode);
		Assert.assertEquals("XOF", code.getSymbol());
		Assert.assertEquals("952", code.getCurrencyCode());
		Assert.assertEquals(0, code.getFractionDigits());
		Assert.assertEquals("CFA Franc BCEAO", code.getCurrencyName());
	}
	
	@Test(description="Iso Code as Argument")
	@Parameters(value={"isoCode","numCode"})
	public void testMultiCode(String isoCode,String numCode){
		System.out.println("+==============TestParam============+");
		code = CodePropertiesLookup.getCodeProperties(isoCode);
		Assert.assertEquals("XOF", code.getSymbol());
		Assert.assertEquals("952", code.getCurrencyCode());
		Assert.assertEquals(0, code.getFractionDigits());
		Assert.assertEquals("CFA Franc BCEAO", code.getCurrencyName());
		
		code = CodePropertiesLookup.getCodeProperties(numCode);
		Assert.assertEquals("XOF", code.getSymbol());
		Assert.assertEquals("952", code.getCurrencyCode());
		Assert.assertEquals(0, code.getFractionDigits());
		Assert.assertEquals("CFA Franc BCEAO", code.getCurrencyName());
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("++++++=======TestParam===========+++++++++++");
		
	}

}
