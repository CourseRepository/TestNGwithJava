package com.csv;

import com.csvreader.CsvReader;

public class CSVDataProvider {
	
	private static CsvReader reader = null;
	private static Object[][] data = null;
	
	private static String getPath(String fileName) {
		String path = CSVFileReader.class.getClassLoader().getResource("com/data").getPath();
		path = path.replaceAll("bin", "src");
		path = path + "/" + fileName;
		return path;
	}
	
	private static void getData(String fileName) {
		int i = 0;
		try {
			data = new Object[12][4];
			reader = new CsvReader(getPath(fileName));
			reader.setComment('#');
			reader.setUseComments(true);
			reader.setSkipEmptyRecords(true);
			while(reader.readRecord()){
				data[i][0] = reader.get(0);
				data[i][1] = reader.get(1);
				data[i][2] = reader.get(2);
				data[i][3] = reader.get(3);
				i++;
			}

		} catch (Exception e) {
		}
	}
	
	
	private static void closeCSV(){
		if(reader != null)
			reader.close();
	}
	public static Object[][] getCSVData(String fileName){
		getData(fileName);
		closeCSV();
		return data;
	}

}

