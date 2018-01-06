package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.CodeProperties;
import com.api.CodePropertiesLookup;


public class TestGroups extends Assert{
	
	private CodeProperties prop = null;
	
	@Test(groups={"ISOCODE"})
	public void testCaseKWD() {
		prop = CodePropertiesLookup.getCodeProperties("KWD");
		assertEquals("KWD", prop.getSymbol());
		assertEquals("414", prop.getCurrencyCode());
		assertEquals("Kuwaiti Dinar", prop.getCurrencyName());
		assertEquals(3, prop.getFractionDigits());
		
	}
	
	@Test(groups={"ISOCODE"})
	public void testCaseCLF() {
		prop = CodePropertiesLookup.getCodeProperties("CLF");
		assertEquals("CLF", prop.getSymbol());
		assertEquals("990", prop.getCurrencyCode());
		assertEquals("Unidad de Fomento", prop.getCurrencyName());
		assertEquals(0, prop.getFractionDigits());
		
	}
	
	@Test(groups={"NUMCODE"})
	public void testCase728() {
		prop = CodePropertiesLookup.getCodeProperties("728");
		assertEquals("SSP", prop.getSymbol());
		assertEquals("728", prop.getCurrencyCode());
		assertEquals("South Sudanese Pound", prop.getCurrencyName());
		assertEquals(2, prop.getFractionDigits());
		
	}
	
	@Test(groups="NUMCODE")
	public void testCase956() {
		prop = CodePropertiesLookup.getCodeProperties("956");
		assertEquals("XBB", prop.getSymbol());
		assertEquals("956", prop.getCurrencyCode());
		assertEquals("Bond Markets Unit European Monetary Unit (E.M.U.-6)", prop.getCurrencyName());
		assertEquals(-1, prop.getFractionDigits());
		
	}
	
	@Test(groups="RANDOM",dependsOnGroups={"NUMCODE","ISOCODE"})
	public void testCase() {
		prop = CodePropertiesLookup.getCodeProperties("956");
		assertEquals("XBB", prop.getSymbol());
		assertEquals("956", prop.getCurrencyCode());
		assertEquals("Bond Markets Unit European Monetary Unit (E.M.U.-6)", prop.getCurrencyName());
		assertEquals(-1, prop.getFractionDigits());
		
	}

}
