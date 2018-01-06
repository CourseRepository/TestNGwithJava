package com.csv;

import java.io.IOException;

import com.csvreader.CsvReader;

public class CSVFileReader {

	private CsvReader reader = null;
	
	
	private String getPath(String fileName) {
		String path = CSVFileReader.class.getClassLoader().getResource("com/data").getPath();
		path = path.replaceAll("bin", "src");
		path = path + "/" + fileName;
		return path;
	}
	
	public void openCSV() {
		try {
			reader = new CsvReader(getPath("data.csv"),':');
			reader.setComment('#');
			reader.setUseComments(true);
			reader.setSkipEmptyRecords(true);
			while(reader.readRecord()){
				System.out.println("IsoCode : " + reader.get(0));
				System.out.println("NumCode : " + reader.get(1));
				System.out.println("Fdigit : " + reader.get(2));
				System.out.println("Name : " + reader.get(3));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void closeCSV() {
		if(reader != null){
			reader.close();
		}
		
	}
	
	
	public static void main(String[] args) {
		CSVFileReader obj = new CSVFileReader();
		obj.openCSV();
		obj.closeCSV();

	}

}
