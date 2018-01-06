package com.dataprovider;

import org.testng.annotations.DataProvider;

import com.csv.CSVDataProvider;

public class DataProviderClass {
	
	@DataProvider(name="getDataFromCSV")
	public static Object[][] getDataFromCSV() {
		return CSVDataProvider.getCSVData("data.csv");
		
	}

}
